package lanou.gift.sorthead.secondraiders;

import android.view.View;
import android.widget.ImageButton;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/3.
 */
public class RaidersHeadActivity extends BaseActivity {
    private ImageButton btn;

    @Override
    protected int getLayout() {
        return R.layout.acticity_guide_head;
    }

    @Override
    protected void initViews() {
        btn = bindView(R.id.btn_recycler_back);

    }

    @Override
    protected void initData() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
