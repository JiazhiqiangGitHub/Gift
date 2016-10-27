package lanou.gift.enter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class EnterActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    private EditText number;
    private EditText password;


    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initViews() {
       btnBack = bindView(R.id.btn_enter_back);
        number = bindView(R.id.et_enter_number);
        password = bindView(R.id.et_enter_password);
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter_back:
                finish();
                break;
        }
    }
}
