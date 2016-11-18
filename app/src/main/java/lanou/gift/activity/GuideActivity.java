package lanou.gift.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class GuideActivity extends BaseActivity implements View.OnClickListener {
    private ImageView backImg;
    private WebView wv;


    @Override
    protected int getLayout() {
        return R.layout.acticity_guide;
    }

    @Override
    protected void initViews() {
        backImg = bindView(R.id.iv_guide_activity_back);
        wv = bindView(R.id.wv_guide);

    }

    @Override
    protected void initData() {
        backImg.setOnClickListener(this);
        Intent intent = getIntent();
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(intent.getStringExtra("second"));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_guide_activity_back:
                finish();
                break;
        }
    }
}
