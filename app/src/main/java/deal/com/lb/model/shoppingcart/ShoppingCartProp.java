
package deal.com.lb.model.shoppingcart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProp {

    @SerializedName("subtotal")
    @Expose
    private Integer subtotal;
    @SerializedName("delivery_charge")
    @Expose
    private String deliveryCharge;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * @return The subtotal
     */
    public Integer getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal The subtotal
     */
    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return The deliveryCharge
     */
    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    /**
     * @param deliveryCharge The delivery_charge
     */
    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    /**
     * @return The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
