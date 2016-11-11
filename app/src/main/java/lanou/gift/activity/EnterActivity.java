package lanou.gift.activity;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class EnterActivity extends BaseActivity implements View.OnClickListener {
    private Button btnBuild,btnEnter;
    private ImageButton btnBack;
    private EditText number;
    private EditText password;
    public static final int ENTER_REQUEST_CODE = 001;//请求码
    public static final int ENTER_RESULT_CODE = 002;//结果码
    private String name;
    private String world;
    private String tel;

    @Override
    protected int getLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initViews() {
        btnBuild = bindView(R.id.btn_enter_test);
        btnBack = bindView(R.id.btn_enter_back);
        number = bindView(R.id.et_enter_number);
        password = bindView(R.id.et_enter_password);
        btnEnter = bindView(R.id.btn_enter_enter);
    }

    @Override
    protected void initData() {
        btnBack.setOnClickListener(this);
        btnBuild.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
        EditTextChangeColor();


    }
    //手机号为11位的时候,才可以点击 变色
    //要现在布局里设置Button 的enabled为false属性
    private void EditTextChangeColor() {
        number.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tel = number.getText().toString().trim();
                if (tel.length() == 11){
                    btnEnter.setEnabled(true);
                    btnEnter.setBackgroundColor(Color.RED);
                }else{
                    btnEnter.setEnabled(false);
                    btnEnter.setBackgroundColor(Color.GRAY);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_enter_back:
                finish();
                break;
            case R.id.btn_enter_test:
                Intent intent = new Intent(EnterActivity.this,EnterTwoActivity.class);
                startActivityForResult(intent,ENTER_REQUEST_CODE);
                break;
            case R.id.btn_enter_enter:
                    finish();
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //传值带的方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ENTER_REQUEST_CODE && resultCode == ENTER_RESULT_CODE){
           if (data != null){
               //接收注册界面的返回值
               name = data.getStringExtra("name");
               world = data.getStringExtra("world");
               if ((!name.isEmpty())&&(!world.isEmpty())){
                   number.setText(name);
                   password.setText(world);
               }
           }
        }
    }
}
