package deal.com.lb.view.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import deal.com.lb.R;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.model.login.LoginProp;

public class ForgetPassword extends BaseActivity {

    private EditText et_email, et_validate;
    private TextView txt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        initUI();
        listners();

    }

    private void initUI() {
        et_email = (EditText) findViewById(R.id.et_email);
        et_validate = (EditText) findViewById(R.id.et_validate);

        txt_submit = (TextView) findViewById(R.id.txt_submit);
    }

    private void listners() {
        txt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString().trim();
                String email1 = et_validate.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    et_email.setError("Enter Email");
                } /*else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    et_email.setError("Enter valid Email");
                } */else if (TextUtils.isEmpty(email1)) {
                    et_validate.setError("Enter Validate Email");
                } /*else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                    et_validate.setError("Enter valid Email");
                }*/ else if (!email.equals(email1)) {
                    showToast("Doesn't Match");
                } else {
                    startProgressDialog();
                    WebHandling.getInstance().forgot(email, new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    showToast(loginProp.getResults().get(0).getMsg());
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}
