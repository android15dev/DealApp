package deal.com.lb.view.adapter;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import deal.com.lb.R;
import deal.com.lb.model.shoppingcart.Result;
import deal.com.lb.view.activities.ShoppingCart;

/**
 * Created by Sahil on 19-07-2016.
 */
public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.HomeViewHolder> {

    private Activity act;

    public Cart_Adapter(Activity activity) {
        act = activity;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_cart, null);
        HomeViewHolder rcv = new HomeViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {

        holder.txt_name.setText(ShoppingCart.results.get(position).getSmallTitle());
        holder.txt_newprice.setText("$ " + ShoppingCart.results.get(position).getPrice());
        holder.txt_oldprice.setText("$ " + ShoppingCart.results.get(position).getOldPrice());
        try {
            holder.txt_off.setText((int) Double.parseDouble(ShoppingCart.results.get(position).getDiscount()) + "% Off");
        } catch (Exception e) {
            e.printStackTrace();
            holder.txt_off.setText(ShoppingCart.results.get(position).getDiscount() + "% Off");
        }
        holder.txt_oldprice.setPaintFlags(holder.txt_oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        ImageLoader.getInstance().displayImage(ShoppingCart.results.get(position).getImgCart(), holder.img);

        if (ShoppingCart.results.get(position).isChecked()) {
            holder.chk.setChecked(true);
        } else {
            holder.chk.setChecked(false);
        }

        holder.chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingCart.getInstance().setcheckdata(holder.chk,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ShoppingCart.results.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView txt_name, txt_newprice, txt_oldprice, txt_off;
        private final CheckBox chk;

        public HomeViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);

            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            txt_newprice = (TextView) itemView.findViewById(R.id.txt_newprice);
            txt_oldprice = (TextView) itemView.findViewById(R.id.txt_oldprice);
            txt_off = (TextView) itemView.findViewById(R.id.txt_off);
            chk = (CheckBox) itemView.findViewById(R.id.chk);

        }

    }

}
