package lanou.gift.activity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class HotActivity extends BaseActivity{
    private WebView wv;
    @Override
    protected int getLayout() {
        return R.layout.acticity_hot;
    }

    @Override
    protected void initViews() {
        wv = bindView(R.id.wv_hot);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        //自适应
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(intent.getStringExtra("secondHot"));
    }
}
