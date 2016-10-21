package lanou.gift.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import lanou.gift.R;
import lanou.gift.guide.guideFragment;
import lanou.gift.hot.hotFragment;
import lanou.gift.mine.mineFragment;
import lanou.gift.sort.classFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton btnGuide;
    private RadioButton btnHot;
    private RadioButton btnClass;
    private RadioButton btnMine;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    //导包
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //表示设置当前的Activity 无Title并且全屏
        //调用这个方法有个限制,即必须在setContentView(R.layout.main);
        //之前调用,否则会抛出异常
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //布局
        setContentView(R.layout.activity_main);

        btnGuide = (RadioButton) findViewById(R.id.btn_main_guide);
        btnHot = (RadioButton) findViewById(R.id.btn_main_hot);
        btnClass = (RadioButton) findViewById(R.id.btn_main_class);
        btnMine = (RadioButton) findViewById(R.id.btn_main_mine);

        //第一次打开界面,首页显示的内容 在onCreate中替换一次
        btnGuide.setChecked(true);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.lb_main, new guideFragment());
        transaction.commit();
        //设置按钮监听
        btnGuide.setOnClickListener(this);
        btnHot.setOnClickListener(this);
        btnClass.setOnClickListener(this);
        btnMine.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.btn_main_guide:
                transaction.replace(R.id.lb_main,new guideFragment());
                break;
            case R.id.btn_main_hot:
                transaction.replace(R.id.lb_main,new hotFragment());
                break;
            case R.id.btn_main_class:
                transaction.replace(R.id.lb_main,new classFragment());
                break;
            case R.id.btn_main_mine:
                transaction.replace(R.id.lb_main,new mineFragment());
                break;
        }
        transaction.commit();
    }
}
