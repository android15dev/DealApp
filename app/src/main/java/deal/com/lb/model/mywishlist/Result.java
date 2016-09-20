package deal.com.lb.model.mywishlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("wishlist_id")
    @Expose
    private String wishlistId;
    @SerializedName("added_on")
    @Expose
    private String addedOn;
    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("img_path")
    @Expose
    private String imgPath;
    @SerializedName("small_title")
    @Expose
    private String smallTitle;
    @SerializedName("deal_price")
    @Expose
    private String dealPrice;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("status")
    @Expose
    private Integer status = 1;
    @SerializedName("msg")
    @Expose
    private String msg;

    /**
     * @return The wishlistId
     */
    public String getWishlistId() {
        return wishlistId;
    }

    /**
     * @param wishlistId The wishlist_id
     */
    public void setWishlistId(String wishlistId) {
        this.wishlistId = wishlistId;
    }

    /**
     * @return The addedOn
     */
    public String getAddedOn() {
        return addedOn;
    }

    /**
     * @param addedOn The added_on
     */
    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    /**
     * @return The dealId
     */
    public String getDealId() {
        return dealId;
    }

    /**
     * @param dealId The deal_id
     */
    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    /**
     * @return The imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath The img_path
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return The smallTitle
     */
    public String getSmallTitle() {
        return smallTitle;
    }

    /**
     * @param smallTitle The small_title
     */
    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    /**
     * @return The dealPrice
     */
    public String getDealPrice() {
        return dealPrice;
    }

    /**
     * @param dealPrice The deal_price
     */
    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    /**
     * @return The salePrice
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * @param salePrice The sale_price
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * @return The expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate The expiry_date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}