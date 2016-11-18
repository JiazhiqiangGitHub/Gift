package lanou.gift.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/11/11.
 */
public class EnterTwoActivity extends BaseActivity implements View.OnClickListener {
    private Button btnBuild;
    private EditText number;
    private EditText password;
    private String tel;
    private String world;

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
        switch (view.getId()) {
            case R.id.btn_enter_two_enter:
                tel = number.getText().toString();
                world = password.getText().toString();
                if ((!tel.isEmpty()) && (!world.isEmpty())) {
                    BmobUser bmobUser = new BmobUser();
                    bmobUser.setUsername(tel);
                    bmobUser.setPassword(world);
                    bmobUser.signUp(new SaveListener<BmobUser>() {
                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if (e == null){
                                Toast.makeText(EnterTwoActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.putExtra("name", tel);
                                intent.putExtra("world", world);
                                setResult(EnterActivity.ENTER_RESULT_CODE, intent);
                                finish();
                            }
                        }
                    });

                } else {
                    Toast.makeText(this, "请完善注册", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
