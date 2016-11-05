package lanou.gift.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.hot.second.commentFragment;
import lanou.gift.hot.second.detailsFragment;
import lanou.gift.hot.second.singleFragment;

/**
 * Created by dllo on 16/11/3.
 */
public class HotActivity extends BaseActivity{
    //// TODO: 16/11/5 完成三页数据
    private TabLayout tb;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    @Override
    protected int getLayout() {
        return R.layout.acticity_hot;
    }

    @Override
    protected void initViews() {
        tb = bindView(R.id.tb_activity_hot);
        vp = bindView(R.id.vp_activity_hot);
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new singleFragment());
        fragments.add(new detailsFragment());
        fragments.add(new commentFragment());

        HotSecondAdapter adapter = new HotSecondAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);












//        Intent intent = getIntent();
//        //自适应
//        wv.getSettings().setJavaScriptEnabled(false);
//        wv.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                url = url.trim();
//                Log.d("Sysout", url);
//                if(url.startsWith("http")&&!url.contains("Download")){
//                  //  view.loadUrl(url);
//                    super.onLoadResource(view, url);
//
//                }
//
//            }
//        });
//        wv.loadUrl(intent.getStringExtra("secondHot"));
    }
}
