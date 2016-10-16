package deal.com.lb.view.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import deal.com.lb.R;

public class FilterActivity extends AppCompatActivity {

    private EditText et_pricefrom, et_priceto;
    private TextView txt_sortby, txt_done;
    CharSequence[] items = {"Newest", "Oldest", "Price Ascending", "Price Descending"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    private void initUI() {
        et_pricefrom = (EditText) findViewById(R.id.et_pricefrom);
        et_priceto = (EditText) findViewById(R.id.et_priceto);
        txt_sortby = (TextView) findViewById(R.id.txt_sortby);
        txt_done = (TextView) findViewById(R.id.txt_done);

        String priceFrom = getIntent().getStringExtra("from");
        String priceTo = getIntent().getStringExtra("to");
        String sortBy = getIntent().getStringExtra("sortby");

        et_pricefrom.setText(priceFrom);
        et_priceto.setText(priceTo);
        txt_sortby.setText(items[Integer.parseInt(sortBy)]);
        txt_sortby.setTag(sortBy);

        txt_sortby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(FilterActivity.this);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        txt_sortby.setText(items[item]);
                        txt_sortby.setTag(item + "");
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        txt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obji = new Intent();
                obji.putExtra("from", et_pricefrom.getText().toString());
                obji.putExtra("to", et_priceto.getText().toString());
                obji.putExtra("sortby", txt_sortby.getTag().toString());
                setResult(RESULT_OK, obji);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
