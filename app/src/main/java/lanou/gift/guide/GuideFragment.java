package lanou.gift.guide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.SearchActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class GuideFragment extends BaseFragment implements View.OnClickListener {

    private ArrayList<Fragment> fragments;
    private TabLayout tbHead;
    private ViewPager vp;
    private ImageButton btnSearch;
    public static final String [] tabTitle = new String[]{"精选","送女票","海淘","创意生活",
            "送基友","送爸妈","送同事"};
    @Override
    protected void initDate() {
//        //添加点击事件
        btnSearch.setOnClickListener(this);

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabTitle.length; i++) {
            if (i == 0){
              fragments.add(new HeadFragment());
            }else {
                fragments.add(TabLayoutFragment.newInstance(i + 1));
            }
        }
        //创建适配器.把ViewPager和适配器 以及TabLayout绑定
        GuideAdapter adapter = new GuideAdapter(getChildFragmentManager(),fragments);
        vp.setAdapter(adapter);
        tbHead.setupWithViewPager(vp);
        //控制TabLayout滑动
        tbHead.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
    @Override
    protected void initView() {
        //布局中为首页创建TabLayout和ViewPager
        tbHead = bindView(R.id.tb_guide_head);
        vp = bindView(R.id.vp_guide);
        btnSearch = bindView(R.id.btn_guide_title_search);
    }

    @Override
    protected int getLayout() {
        //布局
        return R.layout.guide_fragment;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),SearchActivity.class);
        startActivity(intent);
    }
}
