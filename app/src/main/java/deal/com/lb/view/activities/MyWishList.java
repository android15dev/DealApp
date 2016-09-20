package deal.com.lb.view.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.WishList_Handler;
import deal.com.lb.model.mywishlist.WishListProp;
import deal.com.lb.view.adapter.WishList_Adapter;
import deal.com.lb.view.custom.DividerItemDecoration;

public class MyWishList extends BaseToolbarActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wish_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    private void initUI() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_grey), false, true));

        FunctionUtils.getInstance().startProgressDialog(this);

        WebHandling.getInstance().getWishList(new WishList_Handler() {
            @Override
            public void onSuccess(WishListProp wishListProp) {
                FunctionUtils.getInstance().stopDialog();
                if (wishListProp != null) {
                    if (wishListProp.getResults().size() > 0) {
                        if (wishListProp.getResults().get(0).getStatus() == 1) {
                            WishList_Adapter adp = new WishList_Adapter(MyWishList.this, wishListProp.getResults());
                            recycler.setAdapter(adp);
                        } else {
                            FunctionUtils.getInstance().showToast(wishListProp.getResults().get(0).getMsg());
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

}
