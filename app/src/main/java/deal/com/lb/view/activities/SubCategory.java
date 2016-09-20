package deal.com.lb.view.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import deal.com.lb.R;
import deal.com.lb.controller.FunctionUtils;
import deal.com.lb.controller.WebHandling;
import deal.com.lb.controller.handlers.SubCat_Handler;
import deal.com.lb.model.allcat.Result;
import deal.com.lb.model.subcat.SubCatProp;
import deal.com.lb.view.adapter.SubCat_Adapter;

public class SubCategory extends BaseToolbarActivity {

    private Result data;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        data = (Result) getIntent().getSerializableExtra("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(data.getCategoryName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

    }

    private void initUI() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        FunctionUtils.getInstance().startProgressDialog(this);

        WebHandling.getInstance().getSubCat(data.getCategoryId(), new SubCat_Handler() {
            @Override
            public void onSuccess(SubCatProp subCatProp) {
                FunctionUtils.getInstance().stopDialog();
                if (subCatProp != null) {
                    SubCat_Adapter adp = new SubCat_Adapter(SubCategory.this, subCatProp.getResults());
                    recycler.setAdapter(adp);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }


}
