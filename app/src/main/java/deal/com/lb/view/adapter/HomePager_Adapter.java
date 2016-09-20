package deal.com.lb.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import deal.com.lb.R;
import deal.com.lb.model.slideshow.Result;

/**
 * Created by Sahil on 19-07-2016.
 */
public class HomePager_Adapter extends PagerAdapter {

    private Activity act;
    private List<Result> results;

    public HomePager_Adapter(Activity activity, List<Result> results) {
        act = activity;
        this.results = results;

    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((LinearLayout) arg1);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater inf = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inf.inflate(R.layout.view_pager_home, null);

        ImageView img = (ImageView) v.findViewById(R.id.img);

        ImageLoader.getInstance().displayImage(results.get(position).getImagePath(), img);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(results.get(position).getImageLink()));
                act.startActivity(i);
            }
        });

        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
