package deal.com.lb.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.ShoppingCart_Handler;
import deal.com.lb.model.shoppingcart.Result;
import deal.com.lb.model.shoppingcart.ShoppingCartProp;
import deal.com.lb.view.adapter.Cart_Adapter;
import deal.com.lb.view.custom.DividerItemDecoration;

public class ShoppingCart extends AppCompatActivity {

    private static ShoppingCart shoppingcart;
    private RecyclerView recycler;
    private CheckBox chk_selectall;
    private TextView txt_summary, txt_subtotal, txt_shipping, txt_buy, txt_total;

    public static List<Result> results = new ArrayList<>();
    private Cart_Adapter adp;
    private ShoppingCartProp shoppingCartProp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoppingcart = this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    public static ShoppingCart getInstance() {
        return shoppingcart;
    }

    private void initUI() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_grey), false, true));

        chk_selectall = (CheckBox) findViewById(R.id.chk_selectall);
        txt_summary = (TextView) findViewById(R.id.txt_summary);
        txt_subtotal = (TextView) findViewById(R.id.txt_subtotal);
        txt_shipping = (TextView) findViewById(R.id.txt_shipping);
        txt_total = (TextView) findViewById(R.id.txt_total);
        txt_buy = (TextView) findViewById(R.id.txt_buy);

        WebHandling.getInstance().getCart(new ShoppingCart_Handler() {
            @Override
            public void onSuccess(ShoppingCartProp shoppingCartProp) {
                if (shoppingCartProp != null) {
                    if (shoppingCartProp.getResults().size() > 0) {
                        setData(shoppingCartProp);
                    }
                }
            }
        });

    }

    private void setData(final ShoppingCartProp shoppingCartProp) {

        this.shoppingCartProp = shoppingCartProp;
        results = shoppingCartProp.getResults();
        adp = new Cart_Adapter(ShoppingCart.this);
        recycler.setAdapter(adp);

        chk_selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double price = 0.0;
                if (chk_selectall.isChecked()) {
                    for (Result result : results) {
                        result.setChecked(true);
                        price += Double.parseDouble(result.getPrice());
                    }
                    txt_summary.setText("Summary (" + results.size() + " items)");
                    txt_buy.setText("BUY (" + results.size() + ")");
                } else {
                    for (Result result : results) {
                        result.setChecked(false);
                    }
                    txt_summary.setText("Summary (0 items)");
                    txt_buy.setText("BUY (0)");
                }
                adp.notifyDataSetChanged();
                txt_subtotal.setText("US $" + price);
                txt_shipping.setText("US $" + Double.parseDouble(shoppingCartProp.getDeliveryCharge()));
                txt_total.setText("US $" + (price + Double.parseDouble(shoppingCartProp.getDeliveryCharge())));

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setcheckdata(CheckBox chk, int position) {
        if (chk.isChecked()) {
            results.get(position).setChecked(true);
        } else {
            results.get(position).setChecked(false);
        }

        int count = 0;
        double price = 0.0;

        for (Result result : results) {
            if (result.isChecked()) {
                count++;
                price += Double.parseDouble(result.getPrice());
            }
        }

        if (count == results.size()) {
            chk_selectall.setChecked(true);
        } else {
            chk_selectall.setChecked(false);
        }

        txt_summary.setText("Summary (" + count + " items)");
        txt_buy.setText("BUY (" + count + ")");
        txt_subtotal.setText("US $" + price);
        txt_shipping.setText("US $" + Double.parseDouble(shoppingCartProp.getDeliveryCharge()));
        txt_total.setText("US $" + (price + Double.parseDouble(shoppingCartProp.getDeliveryCharge())));

    }
}
