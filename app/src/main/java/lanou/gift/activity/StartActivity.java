package lanou.gift.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class StartActivity extends BaseActivity{
    private ImageView iv;
    private TextView tv;
    Intent intent = null;
    private boolean actived = true;
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



        //计时器
        intent = new Intent(StartActivity.this,MainActivity.class);
        CountDownTimer countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long l) {
                tv.setText("广告剩余时间"+(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                if (actived) {
                    startActivity(intent);
                    finish();
                }
            }
        };
        countDownTimer.start();
    }
}
