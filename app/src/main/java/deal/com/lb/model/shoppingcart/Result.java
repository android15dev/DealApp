
package deal.com.lb.model.shoppingcart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("suborder_id")
    @Expose
    private String suborderId;
    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("prepaid_value")
    @Expose
    private String prepaidValue;
    @SerializedName("img_cart")
    @Expose
    private String imgCart;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("old price")
    @Expose
    private String oldPrice;
    @SerializedName("small_title")
    @Expose
    private String smallTitle;

    private boolean isChecked = false;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    /**
     * @return The suborderId
     */
    public String getSuborderId() {
        return suborderId;
    }

    /**
     * @param suborderId The suborder_id
     */
    public void setSuborderId(String suborderId) {
        this.suborderId = suborderId;
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
     * @return The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return The prepaidValue
     */
    public String getPrepaidValue() {
        return prepaidValue;
    }

    /**
     * @param prepaidValue The prepaid_value
     */
    public void setPrepaidValue(String prepaidValue) {
        this.prepaidValue = prepaidValue;
    }

    /**
     * @return The imgCart
     */
    public String getImgCart() {
        return imgCart;
    }

    /**
     * @param imgCart The img_cart
     */
    public void setImgCart(String imgCart) {
        this.imgCart = imgCart;
    }

    /**
     * @return The discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount The discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @return The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return The oldPrice
     */
    public String getOldPrice() {
        return oldPrice;
    }

    /**
     * @param oldPrice The old price
     */
    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
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

}
