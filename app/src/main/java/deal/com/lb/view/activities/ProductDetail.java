package deal.com.lb.view.activities;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.util.ArrayList;
import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.SharedPref;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.controller.handlers.ProductDetail_Handler;
import deal.com.lb.controller.handlers.ProductImages_Handler;
import deal.com.lb.model.SharedConstants;
import deal.com.lb.model.login.LoginProp;
import deal.com.lb.model.productdetail.ProductDetailProp;
import deal.com.lb.model.productdetail.images.ProductImagesProp;
import deal.com.lb.model.productlist.Result;
import deal.com.lb.view.adapter.DetailPager_Adapter;

public class ProductDetail extends BaseToolbarActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageView img_left, img_right, img_addcart, img_buynow;
    private TextView txt_desc, txt_business, txt_newprice, txt_oldprice, txt_off, txt_rule;
    private CheckBox chk_wishlist;
    private Result data;
    private ViewPager pager;
    private InkPageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        data = (Result) getIntent().getSerializableExtra("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(data.getSmallTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();
    }

    private void initUI() {
        pager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (InkPageIndicator) findViewById(R.id.indicator);

        img_left = (ImageView) findViewById(R.id.img_left);
        img_right = (ImageView) findViewById(R.id.img_right);
        img_addcart = (ImageView) findViewById(R.id.img_addcart);
        img_buynow = (ImageView) findViewById(R.id.img_buynow);

        txt_desc = (TextView) findViewById(R.id.txt_desc);
        txt_newprice = (TextView) findViewById(R.id.txt_newprice);
        txt_oldprice = (TextView) findViewById(R.id.txt_oldprice);
        txt_off = (TextView) findViewById(R.id.txt_off);
        txt_rule = (TextView) findViewById(R.id.txt_rule);
        txt_business = (TextView) findViewById(R.id.txt_business);
        chk_wishlist = (CheckBox) findViewById(R.id.chk_wishlist);

        pager.addOnPageChangeListener(this);
        img_left.setOnClickListener(this);
        img_right.setOnClickListener(this);
        chk_wishlist.setOnClickListener(this);
        img_addcart.setOnClickListener(this);
        img_buynow.setOnClickListener(this);

        getData();

    }

    private void getData() {
        FunctionUtils.getInstance().startProgressDialog(this);

        WebHandling.getInstance().getProductDetail(data.getDealId(), new ProductDetail_Handler() {
                    @Override
                    public void onSuccess(ProductDetailProp productDetailProp) {
                        getImages(productDetailProp.getResults().get(0));
                    }
                }

        );

    }

    private void getImages(final deal.com.lb.model.productdetail.Result productDetailProp) {
        WebHandling.getInstance().getProductImages(data.getDealId(), new ProductImages_Handler() {
            @Override
            public void onSuccess(ProductImagesProp productImagesProp) {
                if (productImagesProp != null) {
                    setData(productDetailProp, productImagesProp);
                }

            }
        });
    }

    private void setData(deal.com.lb.model.productdetail.Result productDetailProp, ProductImagesProp productImagesProp) {

        try {
            productDetailProp.setDescription(productDetailProp.getDescription().replace("\n", "<br>"));
            txt_desc.setText(Html.fromHtml(productDetailProp.getDescription()));
        } catch (Exception e) {
            txt_desc.setText("");
            e.printStackTrace();
        }
        txt_newprice.setText("$ " + productDetailProp.getDealPrice());
        txt_oldprice.setText("$ " + productDetailProp.getSalePrice());
        txt_off.setText("-" + productDetailProp.getDiscount() + "%");
        txt_oldprice.setPaintFlags(txt_oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        try {
            productDetailProp.setRules(productDetailProp.getRules().replace("\n", "<br>"));
            txt_rule.setText(Html.fromHtml(productDetailProp.getRules()));
        } catch (Exception e) {
            txt_rule.setText("");
            e.printStackTrace();
        }
        try {
            productDetailProp.setBusinessInfo(productDetailProp.getBusinessInfo().replace("\n", "<br>"));
            txt_business.setText(Html.fromHtml(productDetailProp.getBusinessInfo()));
        } catch (Exception e) {
            txt_business.setText("");
            e.printStackTrace();
        }

        List<String> li = new ArrayList<>();
        li.add(productDetailProp.getImgPath());

        if (productImagesProp.getResults().get(0).getStatus() == 1) {
            for (deal.com.lb.model.productdetail.images.Result result : productImagesProp.getResults()) {
                li.add(result.getImgPath());
            }
        }
        txt_desc.setMovementMethod(LinkMovementMethod.getInstance());
        txt_rule.setMovementMethod(LinkMovementMethod.getInstance());
        txt_business.setMovementMethod(LinkMovementMethod.getInstance());

        DetailPager_Adapter adp = new DetailPager_Adapter(this, li);
        pager.setAdapter(adp);
        indicator.setViewPager(pager);


        handleVisibility();
        FunctionUtils.getInstance().stopDialog();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
                if (!isFirstPage()) {
                    pager.setCurrentItem(pager.getCurrentItem() - 1, true);
                }
                break;
            case R.id.img_right:
                if (!isLastPage()) {
                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
                }
                break;

            case R.id.img_addcart:
                if (SharedPref.getInstance().getBoolean(SharedConstants.isLoggedIn)) {
                    FunctionUtils.getInstance().startProgressDialog(this);
                    WebHandling.getInstance().addCart(data.getDealId(), new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            FunctionUtils.getInstance().stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    FunctionUtils.getInstance().showToast(loginProp.getResults().get(0).getMsg());
                                }
                            }
                        }
                    });
                } else {
                    startActivity(new Intent(this, LoginScreen.class));
                }
                break;

            case R.id.chk_wishlist:
                if (chk_wishlist.isChecked()) {
                    if (SharedPref.getInstance().getBoolean(SharedConstants.isLoggedIn)) {

                        WebHandling.getInstance().addWishList(data.getDealId(), new Login_Handler() {
                            @Override
                            public void onSuccess(LoginProp loginProp) {
                                if (loginProp != null) {
                                    if (loginProp.getResults().size() > 0) {
                                        if (loginProp.getResults().get(0).getStatus() != 1) {
                                            if (!loginProp.getResults().get(0).getMsg().equals("Item Already Exist In Your Wishlist.")) {
                                                chk_wishlist.setChecked(false);
                                            }
                                        }
                                    } else {
                                        chk_wishlist.setChecked(false);
                                    }
                                } else {
                                    chk_wishlist.setChecked(false);
                                }
                            }
                        });
                    } else {
                        chk_wishlist.setChecked(false);
                        startActivity(new Intent(this, LoginScreen.class));
                    }
                }

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        handleVisibility();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private boolean isLastPage() {
        return pager.getCurrentItem() == pager.getAdapter().getCount() - 1;
    }

    private boolean isFirstPage() {
        return pager.getCurrentItem() == 0;
    }

    private void handleVisibility() {
        if (isFirstPage()) {
            img_left.setVisibility(View.INVISIBLE);
        } else {
            img_left.setVisibility(View.VISIBLE);
        }

        if (isLastPage()) {
            img_right.setVisibility(View.INVISIBLE);
        } else if (pager.getAdapter().getCount() == 0) {
            img_right.setVisibility(View.INVISIBLE);
        } else {
            img_right.setVisibility(View.VISIBLE);
        }
    }

    public void toggleArrowsVisibility(int visibility) {

        if (visibility == View.VISIBLE) {
            if (!isFirstPage()) {
                img_left.setVisibility(visibility);
            }
            if (!isLastPage()) {
                img_right.setVisibility(visibility);
            }
        } else {
            img_left.setVisibility(visibility);
            img_right.setVisibility(visibility);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }
}
