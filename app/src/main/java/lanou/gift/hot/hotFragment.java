package lanou.gift.hot;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.searchActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class hotFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton btnSearch;
    Intent intent = null;
    @Override
    protected void initDate() {
        btnSearch.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnSearch = bindView(R.id.btn_hot_title_search);
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_fragment;
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(getActivity(),searchActivity.class);
        startActivity(intent);
    }
}
