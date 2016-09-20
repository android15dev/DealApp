package deal.com.lb.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.SharedPref;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.model.SharedConstants;
import deal.com.lb.model.login.LoginProp;
import deal.com.lb.model.productlist.Result;
import deal.com.lb.view.activities.LoginScreen;
import deal.com.lb.view.activities.ProductDetail;

/**
 * Created by Sahil on 19-07-2016.
 */
public class ProductList_Adapter extends RecyclerView.Adapter<ProductList_Adapter.HomeViewHolder> {

    private Activity act;
    List<Result> results;

    public ProductList_Adapter(Activity activity, List<Result> results) {
        act = activity;
        this.results = results;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_list, null);
        HomeViewHolder rcv = new HomeViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {

        holder.txt_name.setText(results.get(position).getSmallTitle());
        holder.txt_newprice.setText("$ " + results.get(position).getDealPrice());
        holder.txt_oldprice.setText("$ " + results.get(position).getSalePrice());
        try {
            holder.txt_off.setText((int) Double.parseDouble(results.get(position).getDiscount()) + "% Off");
        } catch (Exception e) {
            e.printStackTrace();
            holder.txt_off.setText(results.get(position).getDiscount() + "% Off");
        }
        holder.txt_oldprice.setPaintFlags(holder.txt_oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        ImageLoader.getInstance().displayImage(results.get(position).getImgPath(), holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.startActivity(new Intent(act, ProductDetail.class).putExtra("data", results.get(position)));
            }
        });

        holder.img_addcart.setVisibility(View.VISIBLE);

        holder.img_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SharedPref.getInstance().getBoolean(SharedConstants.isLoggedIn)) {
                    FunctionUtils.getInstance().startProgressDialog(act);
                    WebHandling.getInstance().addCart(results.get(position).getDealId(), new Login_Handler() {
                        @Override
                        public void onSuccess(LoginProp loginProp) {
                            FunctionUtils.getInstance().stopDialog();
                            if (loginProp != null) {
                                if (loginProp.getResults().size() > 0) {
                                    FunctionUtils.getInstance().showToast(loginProp.getResults().get(0).getMsg());
                                }
                            }
                        }
                    });
                } else {
                    act.startActivity(new Intent(act, LoginScreen.class));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img, img_addcart;
        private final TextView txt_name, txt_newprice, txt_oldprice, txt_off;

        public HomeViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            img_addcart = (ImageView) itemView.findViewById(R.id.img_addcart);

            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            txt_newprice = (TextView) itemView.findViewById(R.id.txt_newprice);
            txt_oldprice = (TextView) itemView.findViewById(R.id.txt_oldprice);
            txt_off = (TextView) itemView.findViewById(R.id.txt_off);

        }


    }

}
