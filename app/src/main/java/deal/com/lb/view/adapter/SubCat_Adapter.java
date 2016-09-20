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
import deal.com.lb.model.subcat.Result;
import deal.com.lb.view.activities.ProductListing;

/**
 * Created by Sahil on 19-07-2016.
 */
public class SubCat_Adapter extends RecyclerView.Adapter<SubCat_Adapter.HomeViewHolder> {

    private Activity act;
    List<Result> results;

    public SubCat_Adapter(Activity activity, List<Result> results) {
        act = activity;
        this.results = results;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cat, null);
        HomeViewHolder rcv = new HomeViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {
        holder.txt.setText(results.get(position).getSubcategoryName());
        ImageLoader.getInstance().displayImage(results.get(position).getSubcategoryImage(), holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.startActivity(new Intent(act, ProductListing.class).putExtra("from", "SubCat").putExtra("data", results.get(position)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt;
        private final ImageView img;

        public HomeViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            txt = (TextView) itemView.findViewById(R.id.txt);
        }


    }

}
