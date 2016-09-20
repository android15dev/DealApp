package deal.com.lb.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.login.LoginManager;

import deal.com.lb.R;
import deal.com.lb.controller.SharedPref;
import deal.com.lb.model.SharedConstants;

public class BaseToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (SharedPref.getInstance().getBoolean(SharedConstants.isLoggedIn)) {
            getMenuInflater().inflate(R.menu.main_myacount, menu);
        } else {
            getMenuInflater().inflate(R.menu.main_login, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:

                break;
            case R.id.action_cart:
                startActivity(new Intent(this, ShoppingCart.class));
                break;
            case R.id.action_myacnt:

                break;
            case R.id.action_wishlist:
                startActivity(new Intent(this, MyWishList.class));
                break;
            case R.id.action_login:
                startActivity(new Intent(this, LoginScreen.class));
                break;
            case R.id.action_logout:
                SharedPref.getInstance().clear();
                LoginManager.getInstance().logOut();
                invalidateOptionsMenu();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
