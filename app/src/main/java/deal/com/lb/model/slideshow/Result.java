package deal.com.lb.model.slideshow;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("image_link")
    @Expose
    private String imageLink;

    /**
     * @return The imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath The image_path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return The imageLink
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     * @param imageLink The image_link
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}