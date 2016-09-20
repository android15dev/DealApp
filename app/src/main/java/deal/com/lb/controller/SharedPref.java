package deal.com.lb.controller;

import android.content.Context;
import android.content.SharedPreferences;

import deal.com.lb.model.SharedConstants;

/**
 * Created by Sahil on 24-07-2016.
 */
public class SharedPref {

    private static Context context;
    private static SharedPref sharedPref;

    public SharedPref(Context context) {
        this.context = context;
        sharedPref = this;
    }

    public static SharedPref getInstance() {
        return sharedPref;
    }

    public void setString(String var_name, String var_value) {
        SharedPreferences prf = context.getSharedPreferences(SharedConstants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prf.edit();
        editor.putString(var_name, var_value);
        editor.commit();
    }

    public String getString(String var_name) {
        SharedPreferences prf = context.getSharedPreferences(SharedConstants.PREF_NAME, Context.MODE_PRIVATE);
        return prf.getString(var_name, "");
    }

    public void setBoolean(String var_name, boolean var_value) {
        SharedPreferences prf = context.getSharedPreferences(SharedConstants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prf.edit();
        editor.putBoolean(var_name, var_value);
        editor.commit();
    }

    public boolean getBoolean(String var_name) {
        SharedPreferences prf = context.getSharedPreferences(SharedConstants.PREF_NAME, Context.MODE_PRIVATE);
        return prf.getBoolean(var_name, false);
    }

    public void clear() {
        SharedPreferences prf = context.getSharedPreferences(SharedConstants.PREF_NAME, Context.MODE_PRIVATE);
        prf.edit().clear().commit();
    }
}
