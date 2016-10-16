package deal.com.lb.view.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.WishList_Handler;
import deal.com.lb.model.mywishlist.Result;
import deal.com.lb.model.mywishlist.WishListProp;
import deal.com.lb.view.adapter.WishList_Adapter;
import deal.com.lb.view.custom.DividerItemDecoration;
import deal.com.lb.view.custom.InteractiveScrollView;

public class MyWishList extends BaseToolbarActivity {

    private RecyclerView recycler;
    private List<Result> wishListData = new ArrayList<>();
    private WishList_Adapter adp;
    //   private ProgressBar bar;
    private InteractiveScrollView scrollView;
    private boolean isLoading = false;
    private int limit = 0;

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
        //    bar = (ProgressBar) findViewById(R.id.bar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        scrollView = (InteractiveScrollView) findViewById(R.id.scrollView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_grey), false, true));

        recycler.setNestedScrollingEnabled(false);

        adp = new WishList_Adapter(MyWishList.this, wishListData);
        recycler.setAdapter(adp);

        FunctionUtils.getInstance().startProgressDialog(this);
        isLoading = true;
        WebHandling.getInstance().getWishList(new WishList_Handler() {
            @Override
            public void onSuccess(WishListProp wishListProp) {
                FunctionUtils.getInstance().stopDialog();
                isLoading = false;
                //   bar.setVisibility(View.GONE);
                if (wishListProp != null) {
                    if (wishListProp.getResults().size() > 0) {
                        setdata(wishListProp);
                    }
                }
            }
        }, limit + "");

        scrollView.setOnBottomReachedListener(new InteractiveScrollView.OnBottomReachedListener() {
            @Override
            public void onBottomReached() {
                if (!isLoading) {
                    if (limit + 20 == wishListData.size()) {
                     //   Log.d("ss", "bottom");
                        FunctionUtils.getInstance().startProgressDialog(MyWishList.this);
                        isLoading = true;
                        limit += 20;
                        WebHandling.getInstance().getWishList(new WishList_Handler() {
                            @Override
                            public void onSuccess(WishListProp wishListProp) {
                                FunctionUtils.getInstance().stopDialog();
                                isLoading = false;
//   bar.setVisibility(View.GONE);
                                if (wishListProp != null) {
                                    if (wishListProp.getResults().size() > 0) {
                                        setdata(wishListProp);
                                    }
                                }
                            }
                        }, limit + "");
                    }
                }
                //  bar.setVisibility(View.VISIBLE);
            }
        });

        /*recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (layoutManager.findLastCompletelyVisibleItemPosition() == wishListData.size() - 1) {
                    //   FunctionUtils.getInstance().showToast("Bottom");
                    Log.d("ss", "bottom");
                    bar.setVisibility(View.VISIBLE);
                }
            }
        });*/

    }

    private void setdata(WishListProp wishListProp) {
        if (wishListProp.getResults().get(0).getStatus() == 1) {
            wishListData.addAll(wishListProp.getResults());
            adp.notifyDataSetChanged();
        } else {
            FunctionUtils.getInstance().showToast(wishListProp.getResults().get(0).getMsg());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

}
