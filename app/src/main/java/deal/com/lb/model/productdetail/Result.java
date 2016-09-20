
package deal.com.lb.model.productdetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("deal_id")
    @Expose
    private String dealId;
    @SerializedName("item_id")
    @Expose
    private String itemId;
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
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("has_options")
    @Expose
    private String hasOptions;
    @SerializedName("business_info")
    @Expose
    private String businessInfo;
    @SerializedName("rules")
    @Expose
    private String rules;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("subcategory_name")
    @Expose
    private String subcategoryName;
    @SerializedName("sub_subcategory_name")
    @Expose
    private String subSubcategoryName;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;

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
     * @return The hasOptions
     */
    public String getHasOptions() {
        return hasOptions;
    }

    /**
     * @param hasOptions The has_options
     */
    public void setHasOptions(String hasOptions) {
        this.hasOptions = hasOptions;
    }

    /**
     * @return The businessInfo
     */
    public String getBusinessInfo() {
        return businessInfo;
    }

    /**
     * @param businessInfo The business_info
     */
    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }

    /**
     * @return The rules
     */
    public String getRules() {
        return rules;
    }

    /**
     * @param rules The rules
     */
    public void setRules(String rules) {
        this.rules = rules;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The subcategoryName
     */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /**
     * @param subcategoryName The subcategory_name
     */
    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    /**
     * @return The subSubcategoryName
     */
    public String getSubSubcategoryName() {
        return subSubcategoryName;
    }

    /**
     * @param subSubcategoryName The sub_subcategory_name
     */
    public void setSubSubcategoryName(String subSubcategoryName) {
        this.subSubcategoryName = subSubcategoryName;
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

}
