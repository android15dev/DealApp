package deal.com.lb.view.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import deal.com.lb.R;
import deal.com.lb.controller.SharedPref;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.model.SharedConstants;
import deal.com.lb.model.login.LoginProp;

public class LoginScreen extends BaseActivity {

    private LoginButton btn_fb;
    private RadioGroup rg_main;
    private RadioButton rb_register, rb_signin;
    private LinearLayout lay_register, lay_signin;
    private EditText et_firstname, et_lastname, et_email, et_phone, et_passwrd, et_cnfrm_pass;
    private TextView txt_register;
    private CheckBox chk_accept;
    private TextView et_gender, et_dob;
    private EditText et_email_signin, et_pass_signin;
    private TextView txt_signin, txt_forget_pass;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        initUI();
        initializeFB();
        listners();
    }

    private void initUI() {
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        rb_register = (RadioButton) findViewById(R.id.rb_register);
        rb_signin = (RadioButton) findViewById(R.id.rb_signin);

        rg_main.check(rb_signin.getId());

        lay_signin = (LinearLayout) findViewById(R.id.lay_signin);
        lay_register = (LinearLayout) findViewById(R.id.lay_register);

        et_firstname = (EditText) findViewById(R.id.et_firstname);
        et_lastname = (EditText) findViewById(R.id.et_lastname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_gender = (TextView) findViewById(R.id.et_gender);
        et_dob = (TextView) findViewById(R.id.et_dob);
        et_passwrd = (EditText) findViewById(R.id.et_passwrd);
        et_cnfrm_pass = (EditText) findViewById(R.id.et_cnfrm_pass);

        et_passwrd.setTypeface(et_firstname.getTypeface());
        et_cnfrm_pass.setTypeface(et_firstname.getTypeface());

        txt_register = (TextView) findViewById(R.id.txt_register);
        chk_accept = (CheckBox) findViewById(R.id.chk_accept);

        et_email_signin = (EditText) findViewById(R.id.et_email_signin);
        et_pass_signin = (EditText) findViewById(R.id.et_pass_signin);

        et_pass_signin.setTypeface(et_email_signin.getTypeface());

        txt_signin = (TextView) findViewById(R.id.txt_signin);
        txt_forget_pass = (TextView) findViewById(R.id.txt_forget_pass);

        btn_fb = (LoginButton) findViewById(R.id.btn_fb);
        btn_fb.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    private void listners() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_signin:
                        rb_signin.setTextColor(Color.BLACK);
                        rb_register.setTextColor(getResources().getColor(R.color.grey));
                        lay_register.setVisibility(View.GONE);
                        lay_signin.setVisibility(View.VISIBLE);
                        break;

                    case R.id.rb_register:
                        rb_register.setTextColor(Color.BLACK);
                        rb_signin.setTextColor(getResources().getColor(R.color.grey));
                        lay_signin.setVisibility(View.GONE);
                        lay_register.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        et_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dia = new DatePickerDialog(activity,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                c.set(Calendar.YEAR, year);
                                c.set(Calendar.MONTH, monthOfYear);
                                c.set(Calendar.DATE, dayOfMonth);
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                et_dob.setText(df.format(c.getTime()));

                            }
                        }, mYear, mMonth, mDay);
                dia.getDatePicker().setMaxDate(System.currentTimeMillis());
                dia.show();
            }
        });

        et_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Female", "Male"};

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        et_gender.setText(items[item]);
                        et_gender.setTag(item + 1);
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        txt_forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, ForgetPassword.class));
            }
        });

        txt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email_signin.getText().toString().trim();
                String pass = et_pass_signin.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    et_email_signin.setError("Enter Email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    et_email_signin.setError("Enter valid Email");
                } else if (TextUtils.isEmpty(pass)) {
                    et_pass_signin.setError("Enter Password");
                } else {
                    startProgressDialog();
                    WebHandling.getInstance().login(email, pass, new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    if (loginProp.getResults().get(0).getStatus() > 0) {
                                        SharedPref.getInstance().setString(SharedConstants.USER_ID, loginProp.getResults().get(0).getUserid());
                                        SharedPref.getInstance().setBoolean(SharedConstants.isLoggedIn, true);
                                        //startActivity(new Intent(activity, HomeScreen.class));
                                        finish();
                                    } else {
                                        showToast(loginProp.getResults().get(0).getMsg());
                                    }
                                }
                            }
                        }
                    });
                }
            }
        });

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = et_firstname.getText().toString().trim();
                String last = et_lastname.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String phone = et_phone.getText().toString().trim();
                String gender = et_gender.getText().toString().trim();
                String dob = et_dob.getText().toString().trim();
                String pass = et_passwrd.getText().toString().trim();
                String cnfrmpass = et_cnfrm_pass.getText().toString().trim();

                if (TextUtils.isEmpty(first)) {
                    et_firstname.setError("Enter Firstname");
                } else if (TextUtils.isEmpty(last)) {
                    et_lastname.setError("Enter LastName");
                } else if (TextUtils.isEmpty(email)) {
                    et_email.setError("Enter Email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    et_email.setError("Enter valid Email");
                } else if (TextUtils.isEmpty(phone)) {
                    et_phone.setError("Enter Phone Number");
                } else if (gender.equals(getString(R.string.gender))) {
                    showToast("Select Gender");
                } else if (dob.equals(getString(R.string.dob))) {
                    showToast("Select DOB");
                } else if (TextUtils.isEmpty(pass)) {
                    et_passwrd.setError("Enter Password");
                } else if (TextUtils.isEmpty(cnfrmpass)) {
                    et_cnfrm_pass.setError("Enter Confirm Password");
                } else if (!pass.equals(cnfrmpass)) {
                    showToast("Password Don't Match");
                } else if (!chk_accept.isChecked()) {
                    showToast("Accept Terms & Condition");
                } else {
                    startProgressDialog();
                    WebHandling.getInstance().register(email, phone, pass, cnfrmpass, first, last, dob, et_gender.getTag() + "", new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    if (loginProp.getResults().get(0).getStatus() > 0) {
                                        clearRegisterationFields();
                                        rg_main.check(rb_signin.getId());
                                    } else {
                                        showToast(loginProp.getResults().get(0).getMsg());
                                    }
                                }
                            }
                        }
                    });
                }

            }
        });
    }

    private void initializeFB() {
        callbackManager = CallbackManager.Factory.create();

        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.d("FB Access Token>>>", loginResult.getAccessToken().getToken() + "");

                final String facebookAccessToken = loginResult.getAccessToken().getToken();

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                try {
                                    String email = object.optString("email");
                                    String id = object.optString("id");
                                    String birthday = object.optString("birthday");
                                    String first_name = object.optString("first_name");
                                    String last_name = object.optString("last_name");
                                    String gender = object.optString("gender");
                                    if (gender.equals("male")) {
                                        gender = "2";
                                    } else {
                                        gender = "1";
                                    }

                                    Log.d("dsd", "ss:   " + object.toString());

                                    showContactDialog(email, id, birthday, first_name, last_name, gender);


                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,birthday,email,first_name,last_name,gender");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                Log.d("Cancelled", "dckljdncj");
            }

            @Override
            public void onError(FacebookException e) {

                e.printStackTrace();
                Log.d("FB Error>>>", e.getMessage());
            }
        };

        btn_fb.setReadPermissions("public_profile", "email", "user_birthday");
        btn_fb.registerCallback(callbackManager, callback);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void clearRegisterationFields() {
        et_firstname.setText("");
        et_lastname.setText("");
        et_email.setText("");
        et_passwrd.setText("");
        et_cnfrm_pass.setText("");
        et_phone.setText("");
        et_gender.setText(getString(R.string.gender));
        et_dob.setText(getString(R.string.dob));
        chk_accept.setChecked(false);
    }

    public void showContactDialog(final String email, final String id, final String birthday, final String first_name, final String last_name, final String gender) {

        final Dialog alertDialogBuilder = new Dialog(activity);
        alertDialogBuilder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater mInflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View alet_view = mInflater.inflate(R.layout.dialog_add_contact, null);
        alertDialogBuilder.setContentView(alet_view);
        alertDialogBuilder.setCancelable(false);

        TextView btn_add = (TextView) alet_view.findViewById(R.id.btn_addcontact);
        final EditText edit_no = (EditText) alet_view.findViewById(R.id.edit_no);
        ImageView close = (ImageView) alet_view.findViewById(R.id.img_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder.dismiss();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = edit_no.getText().toString().trim();
                if (TextUtils.isEmpty(number)) {
                    edit_no.setError("");
                } else {
                    startProgressDialog();
                    WebHandling.getInstance().registerFb(email, first_name, id, last_name, birthday, gender, number, new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    startProgressDialog();
                                    WebHandling.getInstance().loginfb(email, id, new Login_Handler() {
                                        @Override
                                        public void onSuccess(LoginProp loginProp) {
                                            stopDialog();
                                            if (loginProp != null) {
                                                if (loginProp.getResults().size() > 0) {
                                                    if (loginProp.getResults().get(0).getStatus() > 0) {
                                                        SharedPref.getInstance().setString(SharedConstants.USER_ID, loginProp.getResults().get(0).getUserid());
                                                        SharedPref.getInstance().setBoolean(SharedConstants.isLoggedIn, true);
                                                        //startActivity(new Intent(activity, HomeScreen.class));
                                                        finish();
                                                    } else {
                                                        showToast(loginProp.getResults().get(0).getMsg());
                                                    }
                                                }
                                            }
                                        }
                                    });

                                }
                            }
                        }
                    });
                }

            }
        });

        alertDialogBuilder.show();

    }

}
