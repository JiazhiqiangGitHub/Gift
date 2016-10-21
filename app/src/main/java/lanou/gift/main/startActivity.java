package lanou.gift.main;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class startActivity extends BaseActivity{
    private ImageView iv;
    private TextView tv;
    Intent intent = null;
    private boolean actived = true;
    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initViews() {
        iv = bindView(R.id.iv_start);
        tv = bindView(R.id.tv_start);

    }

    @Override
    protected void initData() {
        intent = new Intent(startActivity.this,MainActivity.class);
        CountDownTimer countDownTimer = new CountDownTimer(6000,1000) {
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
