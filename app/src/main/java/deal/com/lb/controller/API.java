package deal.com.lb.controller;

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
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sahil on 19-07-2016.
 */
public interface API {

    @FormUrlEncoded
    @POST("slideshow_ws.php")
    Call<SlideShow_Prop> getSlideShow(@Field("key") String key);

    @FormUrlEncoded
    @POST("homepage_categories_items.php")
    Call<HomeCatProp> getHomeCategories(@Field("key") String key);

    @FormUrlEncoded
    @POST("under_slideshow_ws.php")
    Call<TwoImagesProp> getTwoImages(@Field("key") String key);

    @FormUrlEncoded
    @POST("categories_ws.php")
    Call<AllCat_Prop> getAllcat(@Field("key") String key);

    @FormUrlEncoded
    @POST("subcategories_ws.php")
    Call<SubCatProp> getSubCategory(@Field("key") String key, @Field("cid") String cid);

    @FormUrlEncoded
    @POST("login_ws.php")
    Call<LoginProp> login(@Field("key") String key, @Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("login_ws.php")
    Call<LoginProp> loginFB(@Field("key") String key, @Field("username") String username, @Field("fuid") String fuid);

    @FormUrlEncoded
    @POST("register_ws.php")
    Call<LoginProp> register(@Field("key") String key, @Field("email_address") String email_address, @Field("phone") String phone,
                             @Field("password") String password, @Field("confirm_password") String confirm_password, @Field("first_name") String first_name,
                             @Field("last_name") String last_name, @Field("bday_date") String bday_date, @Field("gender") String gender);

    @FormUrlEncoded
    @POST("register_ws.php")
    Call<LoginProp> registerFB(@Field("key") String key, @Field("email_address") String email_address,
                               @Field("first_name") String first_name, @Field("fuid") String fuid,
                               @Field("last_name") String last_name, @Field("bday_date") String bday_date,
                               @Field("gender") String gender, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("forgot_ws.php")
    Call<LoginProp> forgot(@Field("key") String key, @Field("phone_number") String phone_number);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getProductListBySubId(@Field("key") String key, @Field("sid") String cid);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getProductListByCatId(@Field("key") String key, @Field("cid") String cid);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getValueofDay(@Field("key") String key, @Field("vod") String vod);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getBuy1Get1(@Field("key") String key, @Field("b1g") String b1g);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getStorePickup(@Field("key") String key, @Field("store") String store);

    @FormUrlEncoded
    @POST("products_ws.php")
    Call<ProductListProp> getSearchResult(@Field("key") String key, @Field("keyword") String keyword);

    @FormUrlEncoded
    @POST("product_details_ws.php")
    Call<ProductDetailProp> getProductDetail(@Field("key") String key, @Field("deal_id") String deal_id);

    @FormUrlEncoded
    @POST("product_images_ws.php")
    Call<ProductImagesProp> getProductImages(@Field("key") String key, @Field("deal_id") String deal_id);

    @FormUrlEncoded
    @POST("add_wishlist_ws.php")
    Call<LoginProp> addWishList(@Field("key") String key, @Field("deal_id") String deal_id, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("delete_wishlist_ws.php")
    Call<LoginProp> deleteWishList(@Field("key") String key, @Field("wid") String wid, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("wishlist_ws.php")
    Call<WishListProp> getWishList(@Field("key") String key, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("add_cart_ws.php")
    Call<LoginProp> addCart(@Field("key") String key, @Field("uid") String uid, @Field("deal_id") String deal_id);

    @FormUrlEncoded
    @POST("cart_ws.php")
    Call<ShoppingCartProp> getCart(@Field("key") String key, @Field("uid") String uid);


}
