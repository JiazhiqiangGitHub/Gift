package lanou.gift.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    private ListView lv;
    private RecyclerView rv;
    private RecyclerViewSearchAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        btnBack = bindView(R.id.btn_search_title_back);
        lv = bindView(R.id.lv_search);
        rv = bindView(R.id.rv_search);

    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
