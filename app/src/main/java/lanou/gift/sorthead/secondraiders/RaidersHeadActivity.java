package lanou.gift.sorthead.secondraiders;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class RaidersHeadActivity extends BaseActivity{
    private WebView wv;

    @Override
    protected int getLayout() {
        return R.layout.acticity_guide_head;
    }

    @Override
    protected void initViews() {
        wv = bindView(R.id.wv_raiders_head);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(intent.getStringExtra("secondRaidersHead"));
    }
}
