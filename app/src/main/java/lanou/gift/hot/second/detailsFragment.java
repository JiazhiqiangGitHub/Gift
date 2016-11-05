package lanou.gift.hot.second;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;

/**
 * Created by dllo on 16/11/5.
 */
public class detailsFragment extends BaseFragment {
    private WebView wv;
    @Override
    protected void initDate() {
        Intent intent = getActivity().getIntent();
        //自适应
        wv.getSettings().setJavaScriptEnabled(false);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                url = url.trim();
                Log.d("Sysout", url);
                if(url.startsWith("http")&&!url.contains("Download")){
                  //  view.loadUrl(url);
                    super.onLoadResource(view, url);

                }

            }
        });
        wv.loadUrl(intent.getStringExtra("secondHot"));
    }

    @Override
    protected void initView() {
        wv = bindView(R.id.wv_details);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_details;
    }
}
