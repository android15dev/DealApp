package deal.com.lb.view.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.AllCat_Handler;
import deal.com.lb.model.allcat.AllCat_Prop;
import deal.com.lb.view.adapter.AllCat_Adapter;

public class AllCategory extends BaseToolbarActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    private void initUI() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        FunctionUtils.getInstance().startProgressDialog(this);

        WebHandling.getInstance().getAllCat(new AllCat_Handler() {
            @Override
            public void onSuccess(AllCat_Prop allCat_prop) {
                FunctionUtils.getInstance().stopDialog();
                if (allCat_prop != null) {
                    AllCat_Adapter adp = new AllCat_Adapter(AllCategory.this, allCat_prop.getResults());
                    recycler.setAdapter(adp);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dc", "Dc");
        invalidateOptionsMenu();
    }
}
