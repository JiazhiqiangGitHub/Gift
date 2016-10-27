package lanou.gift.search;

import android.view.View;
import android.widget.ImageButton;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        btnBack = bindView(R.id.btn_search_title_back);

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
