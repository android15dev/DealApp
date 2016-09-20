
package deal.com.lb.model.productlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("deal_price")
    @Expose
    private String dealPrice;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("img_path")
    @Expose
    private String imgPath;
    @SerializedName("small_title")
    @Expose
    private String smallTitle;

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

}
