package lanou.gift.hot.second;

import android.support.v4.view.ViewPager;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;

/**
 * Created by dllo on 16/11/5.
 */
public class singleFragment extends BaseFragment {
    private ViewPager vp;
    private HotThirdOneAdapter adapter;


    @Override
    protected void initDate() {
        HotThirdOneAdapter adapter = new HotThirdOneAdapter();
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_single_fragment);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_single;
    }
}
