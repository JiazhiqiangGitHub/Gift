package lanou.gift.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class GuideActivity extends BaseActivity implements View.OnClickListener {
    private ImageView backImg;
    private ListView lv;
    private GuideActivityAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.acticity_guide;
    }

    @Override
    protected void initViews() {
        backImg = bindView(R.id.iv_guide_activity_back);
        lv = bindView(R.id.lv_guide_activity);
    }

    @Override
    protected void initData() {
        backImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_guide_activity_back:
                finish();
                break;
        }
    }
}
