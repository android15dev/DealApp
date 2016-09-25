
package deal.com.lb.model.homecat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("category_image")
    @Expose
    private String categoryImage;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("deals_nb")
    @Expose
    private Integer dealsNb;
    @SerializedName("item1_img_path")
    @Expose
    private String item1ImgPath;
    @SerializedName("item1_item_id")
    @Expose
    private String item1ItemId;
    @SerializedName("item1_price")
    @Expose
    private String item1Price;
    @SerializedName("item1_discount")
    @Expose
    private String item1Discount;
    @SerializedName("item1_small_title")
    @Expose
    private String item1SmallTitle;
    @SerializedName("item2_img_path")
    @Expose
    private String item2ImgPath;
    @SerializedName("item2_item_id")
    @Expose
    private String item2ItemId;
    @SerializedName("item2_price")
    @Expose
    private String item2Price;
    @SerializedName("item2_discount")
    @Expose
    private String item2Discount;
    @SerializedName("item2_small_title")
    @Expose
    private String item2SmallTitle;
    @SerializedName("item3_img_path")
    @Expose
    private String item3ImgPath;
    @SerializedName("item3_item_id")
    @Expose
    private String item3ItemId;
    @SerializedName("item3_price")
    @Expose
    private String item3Price;
    @SerializedName("item3_discount")
    @Expose
    private String item3Discount;
    @SerializedName("item3_small_title")
    @Expose
    private String item3SmallTitle;
    @SerializedName("item4_img_path")
    @Expose
    private String item4ImgPath;
    @SerializedName("item4_item_id")
    @Expose
    private String item4ItemId;
    @SerializedName("item4_price")
    @Expose
    private String item4Price;
    @SerializedName("item4_discount")
    @Expose
    private String item4Discount;
    @SerializedName("item4_small_title")
    @Expose
    private String item4SmallTitle;

    @SerializedName("item1_deal_id")
    @Expose
    private String item1DealId;
    @SerializedName("item2_deal_id")
    @Expose
    private String item2DealId;
    @SerializedName("item3_deal_id")
    @Expose
    private String item3DealId;
    @SerializedName("item4_deal_id")
    @Expose
    private String item4DealId;

    /**
     * @return The item1DealId
     */
    public String getItem1DealId() {
        return item1DealId;
    }

    /**
     * @param item1DealId The item1_deal_id
     */
    public void setItem1DealId(String item1DealId) {
        this.item1DealId = item1DealId;
    }

    /**
     * @return The item2DealId
     */
    public String getItem2DealId() {
        return item2DealId;
    }

    /**
     * @param item2DealId The item2_deal_id
     */
    public void setItem2DealId(String item2DealId) {
        this.item2DealId = item2DealId;
    }

    /**
     * @return The item3DealId
     */
    public String getItem3DealId() {
        return item3DealId;
    }

    /**
     * @param item3DealId The item3_deal_id
     */
    public void setItem3DealId(String item3DealId) {
        this.item3DealId = item3DealId;
    }

    /**
     * @return The item4DealId
     */
    public String getItem4DealId() {
        return item4DealId;
    }

    /**
     * @param item4DealId The item4_deal_id
     */
    public void setItem4DealId(String item4DealId) {
        this.item4DealId = item4DealId;
    }

    /**
     * @return The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return The categoryImage
     */
    public String getCategoryImage() {
        return categoryImage;
    }

    /**
     * @param categoryImage The category_image
     */
    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    /**
     * @return The categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName The category_name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return The dealsNb
     */
    public Integer getDealsNb() {
        return dealsNb;
    }

    /**
     * @param dealsNb The deals_nb
     */
    public void setDealsNb(Integer dealsNb) {
        this.dealsNb = dealsNb;
    }

    /**
     * @return The item1ImgPath
     */
    public String getItem1ImgPath() {
        return item1ImgPath;
    }

    /**
     * @param item1ImgPath The item1_img_path
     */
    public void setItem1ImgPath(String item1ImgPath) {
        this.item1ImgPath = item1ImgPath;
    }

    /**
     * @return The item1ItemId
     */
    public String getItem1ItemId() {
        return item1ItemId;
    }

    /**
     * @param item1ItemId The item1_item_id
     */
    public void setItem1ItemId(String item1ItemId) {
        this.item1ItemId = item1ItemId;
    }

    /**
     * @return The item1Price
     */
    public String getItem1Price() {
        return item1Price;
    }

    /**
     * @param item1Price The item1_price
     */
    public void setItem1Price(String item1Price) {
        this.item1Price = item1Price;
    }

    /**
     * @return The item1Discount
     */
    public String getItem1Discount() {
        return item1Discount;
    }

    /**
     * @param item1Discount The item1_discount
     */
    public void setItem1Discount(String item1Discount) {
        this.item1Discount = item1Discount;
    }

    /**
     * @return The item1SmallTitle
     */
    public String getItem1SmallTitle() {
        return item1SmallTitle;
    }

    /**
     * @param item1SmallTitle The item1_small_title
     */
    public void setItem1SmallTitle(String item1SmallTitle) {
        this.item1SmallTitle = item1SmallTitle;
    }

    /**
     * @return The item2ImgPath
     */
    public String getItem2ImgPath() {
        return item2ImgPath;
    }

    /**
     * @param item2ImgPath The item2_img_path
     */
    public void setItem2ImgPath(String item2ImgPath) {
        this.item2ImgPath = item2ImgPath;
    }

    /**
     * @return The item2ItemId
     */
    public String getItem2ItemId() {
        return item2ItemId;
    }

    /**
     * @param item2ItemId The item2_item_id
     */
    public void setItem2ItemId(String item2ItemId) {
        this.item2ItemId = item2ItemId;
    }

    /**
     * @return The item2Price
     */
    public String getItem2Price() {
        return item2Price;
    }

    /**
     * @param item2Price The item2_price
     */
    public void setItem2Price(String item2Price) {
        this.item2Price = item2Price;
    }

    /**
     * @return The item2Discount
     */
    public String getItem2Discount() {
        return item2Discount;
    }

    /**
     * @param item2Discount The item2_discount
     */
    public void setItem2Discount(String item2Discount) {
        this.item2Discount = item2Discount;
    }

    /**
     * @return The item2SmallTitle
     */
    public String getItem2SmallTitle() {
        return item2SmallTitle;
    }

    /**
     * @param item2SmallTitle The item2_small_title
     */
    public void setItem2SmallTitle(String item2SmallTitle) {
        this.item2SmallTitle = item2SmallTitle;
    }

    /**
     * @return The item3ImgPath
     */
    public String getItem3ImgPath() {
        return item3ImgPath;
    }

    /**
     * @param item3ImgPath The item3_img_path
     */
    public void setItem3ImgPath(String item3ImgPath) {
        this.item3ImgPath = item3ImgPath;
    }

    /**
     * @return The item3ItemId
     */
    public String getItem3ItemId() {
        return item3ItemId;
    }

    /**
     * @param item3ItemId The item3_item_id
     */
    public void setItem3ItemId(String item3ItemId) {
        this.item3ItemId = item3ItemId;
    }

    /**
     * @return The item3Price
     */
    public String getItem3Price() {
        return item3Price;
    }

    /**
     * @param item3Price The item3_price
     */
    public void setItem3Price(String item3Price) {
        this.item3Price = item3Price;
    }

    /**
     * @return The item3Discount
     */
    public String getItem3Discount() {
        return item3Discount;
    }

    /**
     * @param item3Discount The item3_discount
     */
    public void setItem3Discount(String item3Discount) {
        this.item3Discount = item3Discount;
    }

    /**
     * @return The item3SmallTitle
     */
    public String getItem3SmallTitle() {
        return item3SmallTitle;
    }

    /**
     * @param item3SmallTitle The item3_small_title
     */
    public void setItem3SmallTitle(String item3SmallTitle) {
        this.item3SmallTitle = item3SmallTitle;
    }

    /**
     * @return The item4ImgPath
     */
    public String getItem4ImgPath() {
        return item4ImgPath;
    }

    /**
     * @param item4ImgPath The item4_img_path
     */
    public void setItem4ImgPath(String item4ImgPath) {
        this.item4ImgPath = item4ImgPath;
    }

    /**
     * @return The item4ItemId
     */
    public String getItem4ItemId() {
        return item4ItemId;
    }

    /**
     * @param item4ItemId The item4_item_id
     */
    public void setItem4ItemId(String item4ItemId) {
        this.item4ItemId = item4ItemId;
    }

    /**
     * @return The item4Price
     */
    public String getItem4Price() {
        return item4Price;
    }

    /**
     * @param item4Price The item4_price
     */
    public void setItem4Price(String item4Price) {
        this.item4Price = item4Price;
    }

    /**
     * @return The item4Discount
     */
    public String getItem4Discount() {
        return item4Discount;
    }

    /**
     * @param item4Discount The item4_discount
     */
    public void setItem4Discount(String item4Discount) {
        this.item4Discount = item4Discount;
    }

    /**
     * @return The item4SmallTitle
     */
    public String getItem4SmallTitle() {
        return item4SmallTitle;
    }

    /**
     * @param item4SmallTitle The item4_small_title
     */
    public void setItem4SmallTitle(String item4SmallTitle) {
        this.item4SmallTitle = item4SmallTitle;
    }

}
