package deal.com.lb.model.subcat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable{

    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("subcategory_image")
    @Expose
    private String subcategoryImage;
    @SerializedName("subcategory_name")
    @Expose
    private String subcategoryName;

    /**
     * @return The subcategoryId
     */
    public String getSubcategoryId() {
        return subcategoryId;
    }

    /**
     * @param subcategoryId The subcategory_id
     */
    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    /**
     * @return The subcategoryImage
     */
    public String getSubcategoryImage() {
        return subcategoryImage;
    }

    /**
     * @param subcategoryImage The subcategory_image
     */
    public void setSubcategoryImage(String subcategoryImage) {
        this.subcategoryImage = subcategoryImage;
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

}