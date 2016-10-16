package deal.com.lb.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.ProductList_Handler;
import deal.com.lb.model.productlist.ProductListProp;
import deal.com.lb.model.subcat.Result;
import deal.com.lb.view.adapter.ProductList_Adapter;
import deal.com.lb.view.custom.DividerItemDecoration;
import deal.com.lb.view.custom.InteractiveScrollView;

public class ProductListing extends AppCompatActivity {

    private RecyclerView recycler;
    private Result data_subCat;
    private String from = "";
    private deal.com.lb.model.homecat.Result data_homecat;
    private String search_key = "";
    private int limit = 0;
    private InteractiveScrollView scrollView;
    private boolean isLoading = false;
    private List<deal.com.lb.model.productlist.Result> productsData = new ArrayList<>();
    private ProductList_Adapter adp;
    String priceFrom = "";
    String priceTo = "";
    String sortBy = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        from = getIntent().getStringExtra("from");

        if (from.endsWith("SubCat")) {
            data_subCat = (Result) getIntent().getSerializableExtra("data");
        } else if (from.equals("HomeCat")) {
            data_homecat = (deal.com.lb.model.homecat.Result) getIntent().getSerializableExtra("data");
        } else if (from.equals("Search")) {
            search_key = getIntent().getStringExtra("key");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (from.endsWith("SubCat")) {
            toolbar.setTitle(data_subCat.getSubcategoryName());
        } else if (from.equals("HomeCat")) {
            toolbar.setTitle(data_homecat.getCategoryName());
        } else if (from.equals("Buy1")) {
            toolbar.setTitle("Buy 1 Get 1");
        } else if (from.equals("Store")) {
            toolbar.setTitle("Store Pickup");
        } else if (from.equals("Value")) {
            toolbar.setTitle("Value of the Day");
        } else if (from.equals("Search")) {
            toolbar.setTitle(search_key);
        }
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    private void initUI() {
        scrollView = (InteractiveScrollView) findViewById(R.id.scrollView);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_grey), false, true));
        recycler.setNestedScrollingEnabled(false);


        adp = new ProductList_Adapter(ProductListing.this, productsData);
        recycler.setAdapter(adp);

        isLoading = true;
        getData();

        scrollView.setOnBottomReachedListener(new InteractiveScrollView.OnBottomReachedListener() {
            @Override
            public void onBottomReached() {
                if (!isLoading) {
                    if (limit + 20 == productsData.size()) {
                        limit += 20;
                        isLoading = true;
                        getData();
                    }
                }
            }
        });

    }

    private void setdata(ProductListProp productListProp) {
        productsData.addAll(productListProp.getResults());
        adp.notifyDataSetChanged();
    }

    private void getData() {
        FunctionUtils.getInstance().startProgressDialog(this);

        if (from.endsWith("SubCat")) {
            WebHandling.getInstance().getProductListBySubId(priceFrom, priceTo, sortBy, data_subCat.getSubcategoryId(), new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {

                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {
                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }

                    }
                }
            }, limit + "");
        } else if (from.equals("HomeCat")) {
            WebHandling.getInstance().getProductListByCatId(priceFrom, priceTo, sortBy, data_homecat.getCategoryId(), new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {

                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {

                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }
                    }
                }
            }, limit + "");
        } else if (from.equals("Buy1")) {
            WebHandling.getInstance().getBuy1Get1(priceFrom, priceTo, sortBy, new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {

                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {
                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }
                    }
                }
            }, limit + "");
        } else if (from.equals("Store")) {
            WebHandling.getInstance().getStorePickup(priceFrom, priceTo, sortBy, new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {

                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {
                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }
                    }
                }
            }, limit + "");
        } else if (from.equals("Value")) {
            WebHandling.getInstance().getValueOfDay(priceFrom, priceTo, sortBy, new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {

                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {
                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }
                    }
                }
            }, limit + "");
        } else if (from.equals("Search")) {
            WebHandling.getInstance().getSearchResult(priceFrom, priceTo, sortBy, search_key, new ProductList_Handler() {
                @Override
                public void onSuccess(ProductListProp productListProp) {
                    FunctionUtils.getInstance().stopDialog();
                    isLoading = false;
                    if (productListProp != null) {
                        if (productListProp.getResults().size() > 0) {
                            setdata(productListProp);
                        }
                    }
                }
            }, limit + "");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_filter:
                Intent obji = new Intent(this, FilterActivity.class);
                obji.putExtra("from", priceFrom);
                obji.putExtra("to", priceTo);
                obji.putExtra("sortby", sortBy);
                startActivityForResult(obji, 1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            priceFrom = data.getStringExtra("from");
            priceTo = data.getStringExtra("to");
            sortBy = data.getStringExtra("sortby");
            isLoading = true;
            productsData.clear();
            adp.notifyDataSetChanged();
            getData();
        }
    }
}
