package lanou.gift.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.guide.GuideFragment;
import lanou.gift.hot.HotFirstFragment;
import lanou.gift.mine.MineFragment;
import lanou.gift.sort.ClassFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton btnGuide;
    private RadioButton btnHot;
    private RadioButton btnClass;
    private RadioButton btnMine;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private PopupWindow popupWindow;
    //导包
    @Override
    protected int getLayout() {
        //表示设置当前的Activity 无Title并且全屏
        //调用这个方法有个限制,即必须在setContentView(R.layout.main);
        //之前调用,否则会抛出异常
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_main;
    }
    @Override
    protected void initViews() {
        btnGuide = bindView(R.id.btn_main_guide);
        btnHot = bindView(R.id.btn_main_hot);
        btnClass = bindView(R.id.btn_main_class);
        btnMine = bindView(R.id.btn_main_mine);
    }
    @Override
    protected void initData() {
        //第一次打开界面,首页显示的内容 在onCreate中替换一次
        btnGuide.setChecked(true);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.lb_main, new GuideFragment());
        transaction.commit();
        //设置监听
        btnGuide.setOnClickListener(this);
        btnHot.setOnClickListener(this);
        btnClass.setOnClickListener(this);
        btnMine.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
            switch (view.getId()) {
                case R.id.btn_main_guide:
                    transaction.replace(R.id.lb_main, new GuideFragment());
                    break;
                case R.id.btn_main_hot:
                    transaction.replace(R.id.lb_main, new HotFirstFragment());
                    break;
                case R.id.btn_main_class:
                    transaction.replace(R.id.lb_main, new ClassFragment());
                    break;
                case R.id.btn_main_mine:
                    transaction.replace(R.id.lb_main, new MineFragment());
                    break;

            }
            transaction.commit();

    }

}
