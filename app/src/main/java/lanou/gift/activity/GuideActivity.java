package lanou.gift.activity;

import android.widget.ListView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class GuideActivity extends BaseActivity{
    private ListView lv;
    private GuideActivityAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.acticity_guide;
    }

    @Override
    protected void initViews() {

        lv = bindView(R.id.lv_guide_activity);
    }

    @Override
    protected void initData() {

    }
}
