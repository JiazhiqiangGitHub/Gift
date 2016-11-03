package lanou.gift.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class OneActivity extends BaseActivity{
    private RecyclerView rc;
    private OneActivityAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_one;
    }

    @Override
    protected void initViews() {
        rc = bindView(R.id.rc_activity_one);
    }

    @Override
    protected void initData() {
        adapter = new OneActivityAdapter(this);
        rc.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this,2);
        rc.setLayoutManager(manager);

    }
}
