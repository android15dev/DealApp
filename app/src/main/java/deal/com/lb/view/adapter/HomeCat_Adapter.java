package deal.com.lb.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import deal.com.lb.R;
import deal.com.lb.model.homecat.Result;
import deal.com.lb.view.activities.ProductListing;

/**
 * Created by Sahil on 19-07-2016.
 */
public class HomeCat_Adapter extends RecyclerView.Adapter<HomeCat_Adapter.HomeViewHolder> {

    private Activity act;
    List<Result> results;

    public HomeCat_Adapter(Activity activity, List<Result> results) {
        act = activity;
        this.results = results;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_cat, null);
        HomeViewHolder rcv = new HomeViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {

        holder.txt_cat_name.setText(results.get(position).getCategoryName());
        holder.txt_nodeals.setText(results.get(position).getDealsNb() + " deals");
        holder.txt1.setText(results.get(position).getItem1SmallTitle());
        holder.txt2.setText(results.get(position).getItem2SmallTitle());
        holder.txt3.setText(results.get(position).getItem3SmallTitle());
        holder.txt4.setText(results.get(position).getItem4SmallTitle());
        holder.txt_price1.setText("$ " + results.get(position).getItem1Price());
        holder.txt_price2.setText("$ " + results.get(position).getItem2Price());
        holder.txt_price3.setText("$ " + results.get(position).getItem3Price());
        holder.txt_price4.setText("$ " + results.get(position).getItem4Price());
        holder.txt_off1.setText(results.get(position).getItem1Discount() + "% Off");
        holder.txt_off2.setText(results.get(position).getItem2Discount() + "% Off");
        holder.txt_off3.setText(results.get(position).getItem3Discount() + "% Off");
        holder.txt_off4.setText(results.get(position).getItem4Discount() + "% Off");

        ImageLoader.getInstance().displayImage(results.get(position).getItem1ImgPath(), holder.img1);
        ImageLoader.getInstance().displayImage(results.get(position).getItem2ImgPath(), holder.img2);
        ImageLoader.getInstance().displayImage(results.get(position).getItem3ImgPath(), holder.img3);
        ImageLoader.getInstance().displayImage(results.get(position).getItem4ImgPath(), holder.img4);

        holder.txt_viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.startActivity(new Intent(act, ProductListing.class).putExtra("from", "HomeCat").putExtra("data", results.get(position)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {


        private final TextView txt_cat_name, txt_nodeals, txt_viewmore;
        private final ImageView img1, img2, img3, img4;
        private final TextView txt1, txt2, txt3, txt4;
        private final TextView txt_price1, txt_price2, txt_price3, txt_price4;
        private final TextView txt_off1, txt_off2, txt_off3, txt_off4;

        public HomeViewHolder(View itemView) {
            super(itemView);

            img1 = (ImageView) itemView.findViewById(R.id.img1);
            img2 = (ImageView) itemView.findViewById(R.id.img2);
            img3 = (ImageView) itemView.findViewById(R.id.img3);
            img4 = (ImageView) itemView.findViewById(R.id.img4);

            txt_cat_name = (TextView) itemView.findViewById(R.id.txt_cat_name);
            txt_nodeals = (TextView) itemView.findViewById(R.id.txt_nodeals);
            txt_viewmore = (TextView) itemView.findViewById(R.id.txt_viewmore);

            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            txt2 = (TextView) itemView.findViewById(R.id.txt2);
            txt3 = (TextView) itemView.findViewById(R.id.txt3);
            txt4 = (TextView) itemView.findViewById(R.id.txt4);

            txt_price1 = (TextView) itemView.findViewById(R.id.txt_price1);
            txt_price2 = (TextView) itemView.findViewById(R.id.txt_price2);
            txt_price3 = (TextView) itemView.findViewById(R.id.txt_price3);
            txt_price4 = (TextView) itemView.findViewById(R.id.txt_price4);

            txt_off1 = (TextView) itemView.findViewById(R.id.txt_off1);
            txt_off2 = (TextView) itemView.findViewById(R.id.txt_off2);
            txt_off3 = (TextView) itemView.findViewById(R.id.txt_off3);
            txt_off4 = (TextView) itemView.findViewById(R.id.txt_off4);
        }


    }

}
