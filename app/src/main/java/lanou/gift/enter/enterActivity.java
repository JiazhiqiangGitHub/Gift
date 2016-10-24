package lanou.gift.enter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class enterActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    Intent intent = null;
    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initViews() {
       btnBack = bindView(R.id.btn_enter_back);
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter_back:
                intent = new Intent();
                finish();
                break;
        }
    }
}