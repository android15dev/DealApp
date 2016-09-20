package deal.com.lb.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import deal.com.lb.R;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity, HomeScreen.class));
                finish();
            }
        }, 2000);

    }
}
