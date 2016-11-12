package lanou.gift.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/11.
 */
public class EnterTwoActivity extends BaseActivity implements View.OnClickListener {
    private Button btnBuild;
    private EditText number;
    private EditText password;
    @Override
    protected int getLayout() {
        return R.layout.activity_two_enter;
    }

    @Override
    protected void initViews() {
        btnBuild = bindView(R.id.btn_enter_two_enter);
        number = bindView(R.id.et_enter_two_number);
        password = bindView(R.id.et_enter_two_password);

    }

    @Override
    protected void initData() {
        btnBuild.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter_two_enter:
                String tel = number.getText().toString();
                String world = password.getText().toString();
                if ((!tel.isEmpty())&&(!world.isEmpty())) {
                    Intent intent = new Intent();
                    intent.putExtra("name",tel);
                    intent.putExtra("world",world);
                    setResult(EnterActivity.ENTER_RESULT_CODE,intent);
                    finish();
                }else{
                    Toast.makeText(this, "请注册", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
