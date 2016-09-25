package deal.com.lb.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pixelcan.inkpageindicator.InkPageIndicator;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.HomeCategory_Handler;
import deal.com.lb.controller.handlers.SlideShow_Handler;
import deal.com.lb.controller.handlers.TwoImage_Handler;
import deal.com.lb.model.homecat.HomeCatProp;
import deal.com.lb.model.slideshow.SlideShow_Prop;
import deal.com.lb.model.twoimages.TwoImagesProp;
import deal.com.lb.view.adapter.HomeCat_Adapter;
import deal.com.lb.view.adapter.HomePager_Adapter;

public class HomeScreen extends BaseActivity implements View.OnClickListener {


    private ViewPager pager;
    private InkPageIndicator indicator;
    private ImageView img1, img2;
    private RecyclerView recycler;
    private LinearLayout lay_allcat, lay_storepickup, lay_buy1get1, lay_valueofday;
    private EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        initUI();
        getData();
    }

    private void initUI() {
        pager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (InkPageIndicator) findViewById(R.id.indicator);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(activity));
        recycler.setNestedScrollingEnabled(false);

        et_search = (EditText) findViewById(R.id.et_search);

        lay_allcat = (LinearLayout) findViewById(R.id.lay_allcat);
        lay_buy1get1 = (LinearLayout) findViewById(R.id.lay_buy1get1);
        lay_storepickup = (LinearLayout) findViewById(R.id.lay_storepickup);
        lay_valueofday = (LinearLayout) findViewById(R.id.lay_valueofday);

        lay_allcat.setOnClickListener(this);
        lay_buy1get1.setOnClickListener(this);
        lay_storepickup.setOnClickListener(this);
        lay_valueofday.setOnClickListener(this);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    FunctionUtils.getInstance().hideSoftKeyboard(activity);
                    startActivity(new Intent(activity, ProductListing.class).putExtra("from", "Search").putExtra("key", et_search.getText().toString().trim()));
                    return true;
                }
                return false;
            }
        });

    }

    private void getData() {

        WebHandling.getInstance().getSlideShow(new SlideShow_Handler() {
            @Override
            public void onSuccess(SlideShow_Prop slideShow_prop) {
                if (slideShow_prop != null) {
                    HomePager_Adapter adp = new HomePager_Adapter(activity, slideShow_prop.getResults());
                    pager.setAdapter(adp);
                    indicator.setViewPager(pager);
                }
                WebHandling.getInstance().getTwoImages(new TwoImage_Handler() {
                    @Override
                    public void onSuccess(final TwoImagesProp twoImagesProp) {
                        if (twoImagesProp != null) {
                            if (twoImagesProp.getResults().size() > 0) {
                                ImageLoader.getInstance().displayImage(twoImagesProp.getResults().get(0).getImg1Path(), img1);
                                ImageLoader.getInstance().displayImage(twoImagesProp.getResults().get(0).getImg2Path(), img2);

                                img1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        openUrl(twoImagesProp.getResults().get(0).getImg1Link());
                                    }
                                });
                                img2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        openUrl(twoImagesProp.getResults().get(0).getImg2Link());
                                    }
                                });
                            }
                        }
                        WebHandling.getInstance().getHomeCategories(new HomeCategory_Handler() {
                            @Override
                            public void onSuccess(HomeCatProp homeCatProp) {
                                if (homeCatProp != null) {
                                    HomeCat_Adapter adp = new HomeCat_Adapter(activity, homeCatProp.getResults());
                                    recycler.setAdapter(adp);
                                }
                            }
                        });
                    }
                });
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lay_allcat:
                startActivity(new Intent(activity, AllCategory.class));
                break;
            case R.id.lay_buy1get1:
                startActivity(new Intent(activity, ProductListing.class).putExtra("from", "Buy1"));
                break;
            case R.id.lay_storepickup:
                startActivity(new Intent(activity, ProductListing.class).putExtra("from", "Store"));
                break;
            case R.id.lay_valueofday:
                startActivity(new Intent(activity, ProductListing.class).putExtra("from", "Value"));
                break;
        }
    }
}
