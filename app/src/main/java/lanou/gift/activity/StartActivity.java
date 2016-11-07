package lanou.gift.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;


/**
 * Created by dllo on 16/10/21.
 */
public class StartActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;
    private TextView tv;
    Intent intent = null;
    private boolean mFirst;
    private SharedPreferences shared;
    private PopupWindow pop;
    private LinearLayout ll;

    //判断是否是第一次
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            //用what只存在一种值
            if (message.what == 1){
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
            }else{
                TranslateAnimation down = new TranslateAnimation(0,0,-200,0);
                //位置
                down.setFillAfter(true);//让动画停在最后一帧
                down.setInterpolator(new BounceInterpolator());//跳动
                down.setDuration(3000);//时间

                ll.startAnimation(down);
                pop.showAsDropDown(tv,-200,200);


            }
            return false;
        }
    });
    private ImageButton btnNext;
    private ImageView btnClose;


    @Override
    protected int getLayout() {
        //布局文件中 注册以及调换activity的位置
        return R.layout.activity_start;
    }

    @Override
    protected void initViews() {
        iv = bindView(R.id.iv_start);
        tv = bindView(R.id.tv_start);

    }


    @Override
    protected void initData() {
        shared = getPreferences(MODE_PRIVATE);
        mFirst = shared.getBoolean("1", true);
        if (!mFirst) {
            //空消息睡眠三秒
            handler.sendEmptyMessageDelayed(1, 3000);
        } else {
            //创造pop
            pop = creatPop();
            handler.sendEmptyMessageDelayed(2, 3000);
        }
        mFirst = false;
        SharedPreferences.Editor e = shared.edit();
        e.putBoolean("1", false);
        e.commit();

    }

    private PopupWindow creatPop() {
        pop = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.start_pop,null);
        ll = (LinearLayout) view.findViewById(R.id.ll_pop_one);
        btnNext = (ImageButton) view.findViewById(R.id.popOne_next);
        btnClose = (ImageView) view.findViewById(R.id.img_close);

        pop.setWidth(430);
        pop.setHeight(630);
        pop.setContentView(view);
        pop.setFocusable(true);
        btnNext.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        return pop;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.popOne_next:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.img_close:
                pop.dismiss();
                handler.sendEmptyMessageDelayed(1,3000);
                break;

        }

    }
}
