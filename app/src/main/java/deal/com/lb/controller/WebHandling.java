package deal.com.lb.controller;

import java.util.concurrent.TimeUnit;

import deal.com.lb.controller.handlers.AllCat_Handler;
import deal.com.lb.controller.handlers.HomeCategory_Handler;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.controller.handlers.ProductDetail_Handler;
import deal.com.lb.controller.handlers.ProductImages_Handler;
import deal.com.lb.controller.handlers.ProductList_Handler;
import deal.com.lb.controller.handlers.ShoppingCart_Handler;
import deal.com.lb.controller.handlers.SlideShow_Handler;
import deal.com.lb.controller.handlers.SubCat_Handler;
import deal.com.lb.controller.handlers.TwoImage_Handler;
import deal.com.lb.controller.handlers.WishList_Handler;
import deal.com.lb.model.Constants;
import deal.com.lb.model.SharedConstants;
import deal.com.lb.model.allcat.AllCat_Prop;
import deal.com.lb.model.homecat.HomeCatProp;
import deal.com.lb.model.login.LoginProp;
import deal.com.lb.model.mywishlist.WishListProp;
import deal.com.lb.model.productdetail.ProductDetailProp;
import deal.com.lb.model.productdetail.images.ProductImagesProp;
import deal.com.lb.model.productlist.ProductListProp;
import deal.com.lb.model.shoppingcart.ShoppingCartProp;
import deal.com.lb.model.slideshow.SlideShow_Prop;
import deal.com.lb.model.subcat.SubCatProp;
import deal.com.lb.model.twoimages.TwoImagesProp;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sahil on 19-07-2016.
 */
public class WebHandling {

    private static API api;
    private static WebHandling webHandling;

    public WebHandling() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        webHandling = this;
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(API.class);
    }

    public static WebHandling getInstance() {
        return webHandling;
    }

    public void getSlideShow(final SlideShow_Handler slideShow_handler) {
        Call<SlideShow_Prop> call = api.getSlideShow(Constants.KEY);

        call.enqueue(new Callback<SlideShow_Prop>() {
            @Override
            public void onResponse(Call<SlideShow_Prop> call, Response<SlideShow_Prop> response) {
                slideShow_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SlideShow_Prop> call, Throwable t) {
                slideShow_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getHomeCategories(final HomeCategory_Handler homeCategory_handler) {
        Call<HomeCatProp> call = api.getHomeCategories(Constants.KEY);

        call.enqueue(new Callback<HomeCatProp>() {
            @Override
            public void onResponse(Call<HomeCatProp> call, Response<HomeCatProp> response) {
                homeCategory_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<HomeCatProp> call, Throwable t) {
                homeCategory_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getTwoImages(final TwoImage_Handler twoImage_handler) {
        Call<TwoImagesProp> call = api.getTwoImages(Constants.KEY);

        call.enqueue(new Callback<TwoImagesProp>() {
            @Override
            public void onResponse(Call<TwoImagesProp> call, Response<TwoImagesProp> response) {
                twoImage_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TwoImagesProp> call, Throwable t) {
                twoImage_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void login(String username, String password, final Login_Handler login_handler) {
        Call<LoginProp> call = api.login(Constants.KEY, username, password);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void loginfb(String email, String fuid, final Login_Handler login_handler) {
        Call<LoginProp> call = api.loginFB(Constants.KEY, email, fuid);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void register(String email, String phone, String pass, String cnfrm_pass, String first,
                         String last, String bday, String gender, final Login_Handler login_handler) {
        Call<LoginProp> call = api.register(Constants.KEY, email, phone, pass, cnfrm_pass, first, last, bday, gender);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void registerFb(String email, String fuid, String first, String last,
                           String bday, String gender, String phone, final Login_Handler login_handler) {
        Call<LoginProp> call = api.registerFB(Constants.KEY, email, first, fuid, last, bday, gender, phone);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void forgot(String text, final Login_Handler login_handler) {
        Call<LoginProp> call = api.forgot(Constants.KEY, text);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getAllCat(final AllCat_Handler allCat_handler) {
        Call<AllCat_Prop> call = api.getAllcat(Constants.KEY);

        call.enqueue(new Callback<AllCat_Prop>() {
            @Override
            public void onResponse(Call<AllCat_Prop> call, Response<AllCat_Prop> response) {
                allCat_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AllCat_Prop> call, Throwable t) {
                allCat_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getSubCat(String id, final SubCat_Handler subCat_handler) {

        Call<SubCatProp> call = api.getSubCategory(Constants.KEY, id);

        call.enqueue(new Callback<SubCatProp>() {
            @Override
            public void onResponse(Call<SubCatProp> call, Response<SubCatProp> response) {
                subCat_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCatProp> call, Throwable t) {
                subCat_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getProductListBySubId(String id, final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getProductListBySubId(Constants.KEY, id);

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getProductListByCatId(String id, final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getProductListByCatId(Constants.KEY, id);

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getProductDetail(String id, final ProductDetail_Handler productDetail_handler) {
        Call<ProductDetailProp> call = api.getProductDetail(Constants.KEY, id);

        call.enqueue(new Callback<ProductDetailProp>() {
            @Override
            public void onResponse(Call<ProductDetailProp> call, Response<ProductDetailProp> response) {
                productDetail_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductDetailProp> call, Throwable t) {
                productDetail_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getProductImages(String id, final ProductImages_Handler productImages_handler) {
        Call<ProductImagesProp> call = api.getProductImages(Constants.KEY, id);

        call.enqueue(new Callback<ProductImagesProp>() {
            @Override
            public void onResponse(Call<ProductImagesProp> call, Response<ProductImagesProp> response) {
                productImages_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductImagesProp> call, Throwable t) {
                productImages_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void addWishList(String deal_id, final Login_Handler login_handler) {
        Call<LoginProp> call = api.addWishList(Constants.KEY, deal_id, SharedPref.getInstance().getString(SharedConstants.USER_ID));

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void deleteWishList(String wid, final Login_Handler login_handler) {
        Call<LoginProp> call = api.deleteWishList(Constants.KEY, wid, SharedPref.getInstance().getString(SharedConstants.USER_ID));

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getWishList(final WishList_Handler wishList_handler) {
        Call<WishListProp> call = api.getWishList(Constants.KEY, SharedPref.getInstance().getString(SharedConstants.USER_ID));

        call.enqueue(new Callback<WishListProp>() {
            @Override
            public void onResponse(Call<WishListProp> call, Response<WishListProp> response) {
                wishList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WishListProp> call, Throwable t) {
                wishList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void addCart(String dealid, final Login_Handler login_handler) {
        Call<LoginProp> call = api.addCart(Constants.KEY, SharedPref.getInstance().getString(SharedConstants.USER_ID), dealid);

        call.enqueue(new Callback<LoginProp>() {
            @Override
            public void onResponse(Call<LoginProp> call, Response<LoginProp> response) {
                login_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginProp> call, Throwable t) {
                login_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getCart(final ShoppingCart_Handler shoppingCart_handler) {
        Call<ShoppingCartProp> call = api.getCart(Constants.KEY, SharedPref.getInstance().getString(SharedConstants.USER_ID));

        call.enqueue(new Callback<ShoppingCartProp>() {
            @Override
            public void onResponse(Call<ShoppingCartProp> call, Response<ShoppingCartProp> response) {
                shoppingCart_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ShoppingCartProp> call, Throwable t) {
                shoppingCart_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getStorePickup(final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getStorePickup(Constants.KEY, "1");

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getBuy1Get1(final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getBuy1Get1(Constants.KEY, "1");

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getValueOfDay(final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getValueofDay(Constants.KEY, "1");

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }

    public void getSearchResult(String key, final ProductList_Handler productList_handler) {

        Call<ProductListProp> call = api.getSearchResult(Constants.KEY, key);

        call.enqueue(new Callback<ProductListProp>() {
            @Override
            public void onResponse(Call<ProductListProp> call, Response<ProductListProp> response) {
                productList_handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductListProp> call, Throwable t) {
                productList_handler.onSuccess(null);
                t.printStackTrace();
            }
        });
    }


}
