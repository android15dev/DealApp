package deal.com.lb.view.adapter;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.Login_Handler;
import deal.com.lb.model.login.LoginProp;
import deal.com.lb.model.mywishlist.Result;

/**
 * Created by Sahil on 19-07-2016.
 */
public class WishList_Adapter extends RecyclerView.Adapter<WishList_Adapter.HomeViewHolder> {

    private Activity act;
    List<Result> results;

    public WishList_Adapter(Activity activity, List<Result> results) {
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
        holder.txt_off.setVisibility(View.GONE);
       /* try {
            holder.txt_off.setText((int) Double.parseDouble(results.get(position).getDiscount()) + "% Off");
        } catch (Exception e) {
            e.printStackTrace();
            holder.txt_off.setText(results.get(position).getDiscount() + "% Off");
        }*/
        holder.txt_oldprice.setPaintFlags(holder.txt_oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        ImageLoader.getInstance().displayImage(results.get(position).getImgPath(), holder.img);

        holder.img_more.setVisibility(View.VISIBLE);
        holder.img_more.setTag(position);
        holder.img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popup = new PopupMenu(act, v);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_remove, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        FunctionUtils.getInstance().startProgressDialog(act);
                        WebHandling.getInstance().deleteWishList(results.get((int) v.getTag()).getWishlistId(), new Login_Handler() {
                            @Override
                            public void onSuccess(LoginProp loginProp) {
                                FunctionUtils.getInstance().stopDialog();
                                if (loginProp != null) {
                                    if (loginProp.getResults().size() > 0) {
                                        if (loginProp.getResults().get(0).getStatus() == 1) {
                                            results.remove((int) v.getTag());
                                            notifyDataSetChanged();
                                        }
                                    }
                                }
                            }
                        });

                        return true;
                    }
                });

                popup.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img, img_more;
        private final TextView txt_name, txt_newprice, txt_oldprice, txt_off;

        public HomeViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            img_more = (ImageView) itemView.findViewById(R.id.img_more);

            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            txt_newprice = (TextView) itemView.findViewById(R.id.txt_newprice);
            txt_oldprice = (TextView) itemView.findViewById(R.id.txt_oldprice);
            txt_off = (TextView) itemView.findViewById(R.id.txt_off);

        }


    }

}
