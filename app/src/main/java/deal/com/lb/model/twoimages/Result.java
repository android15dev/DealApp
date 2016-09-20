package deal.com.lb.model.twoimages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("img1_path")
    @Expose
    private String img1Path;
    @SerializedName("img1_link")
    @Expose
    private String img1Link;
    @SerializedName("img2_path")
    @Expose
    private String img2Path;
    @SerializedName("img2_link")
    @Expose
    private String img2Link;

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
     * @return The img1Path
     */
    public String getImg1Path() {
        return img1Path;
    }

    /**
     * @param img1Path The img1_path
     */
    public void setImg1Path(String img1Path) {
        this.img1Path = img1Path;
    }

    /**
     * @return The img1Link
     */
    public String getImg1Link() {
        return img1Link;
    }

    /**
     * @param img1Link The img1_link
     */
    public void setImg1Link(String img1Link) {
        this.img1Link = img1Link;
    }

    /**
     * @return The img2Path
     */
    public String getImg2Path() {
        return img2Path;
    }

    /**
     * @param img2Path The img2_path
     */
    public void setImg2Path(String img2Path) {
        this.img2Path = img2Path;
    }

    /**
     * @return The img2Link
     */
    public String getImg2Link() {
        return img2Link;
    }

    /**
     * @param img2Link The img2_link
     */
    public void setImg2Link(String img2Link) {
        this.img2Link = img2Link;
    }

}