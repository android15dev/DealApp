package deal.com.lb.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by Sahil on 20-07-2016.
 */
public class FunctionUtils {

    private static Context context;
    private static FunctionUtils functionUtils;

    public FunctionUtils(Context context) {
        this.context = context;
        functionUtils = this;
    }

    public static FunctionUtils getInstance() {
        return functionUtils;
    }

    private ProgressDialog dia;

    public void startProgressDialog(Activity activity) {
        dia = new ProgressDialog(activity);
        dia.setMessage("Loading...");
        dia.setCancelable(false);
        dia.show();
    }

    public void stopDialog() {
        if (dia != null && dia.isShowing()) {
            dia.cancel();
        }
    }

    public void showToast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public void hideSoftKeyboard(Activity act) {
        try {
            InputMethodManager imm = (InputMethodManager) act.getSystemService(act.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(act.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
