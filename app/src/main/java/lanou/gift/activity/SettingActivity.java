package lanou.gift.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;

/**
 * Created by dllo on 16/10/25.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout ll;
    private TextView tvSex,tvJob;
    private SharedPreferences shared;
    private PopupWindow pop,popTwo;
    private ImageButton one,two,three,four,five,enter,boy,girl,next,settingBack;
    private ImageView back,closeTwo,close;
    private LinearLayout llOne,llTwo;
    private FrameLayout fl;
    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        ll = bindView(R.id.ll_setting);
        tvSex = bindView(R.id.tv_setting_sex);
        tvJob = bindView(R.id.tv_setting_job);
        settingBack = bindView(R.id.setting_back);
        fl = bindView(R.id.setting_fl_tel);

    }

    @Override
    protected void initData() {
       settingBack.setOnClickListener(this);
       ll.setOnClickListener(this);
       pop = creatPop();
       popTwo = creatPopTwo();
        fl.setOnClickListener(this);
       shared = getPreferences(MODE_PRIVATE);

    }

    private PopupWindow creatPopTwo() {
        popTwo = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.pop_item_two,null);
        popTwo.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popTwo.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        llTwo =llOne = (LinearLayout) view.findViewById(R.id.ll_pop_two);
        one = (ImageButton) view.findViewById(R.id.one);
        two = (ImageButton) view.findViewById(R.id.two);
        three = (ImageButton) view.findViewById(R.id.three);
        four = (ImageButton) view.findViewById(R.id.four);
        five = (ImageButton) view.findViewById(R.id.five);
        enter = (ImageButton) view.findViewById(R.id.btn_enter_app);
        back = (ImageView) view.findViewById(R.id.pop_two_back);
        closeTwo = (ImageView) view.findViewById(R.id.pop_two_close);

        one.setOnClickListener(this);
        three.setOnClickListener(this);
        two.setOnClickListener(this);
        five.setOnClickListener(this);
        four.setOnClickListener(this);
        back.setOnClickListener(this);
        closeTwo.setOnClickListener(this);
        enter.setOnClickListener(this);

        popTwo.setContentView(view);
        popTwo.setFocusable(true);

        return popTwo;
    }

    private PopupWindow creatPop() {
        pop = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.start_pop,null);
        next = (ImageButton) view.findViewById(R.id.popOne_next);
        close = (ImageView) view.findViewById(R.id.img_close);
        llOne = (LinearLayout) view.findViewById(R.id.ll_pop_one);
        boy = (ImageButton) view.findViewById(R.id.img_boy);
        girl = (ImageButton) view.findViewById(R.id.img_gril);
        boy.setOnClickListener(this);
        girl.setOnClickListener(this);
        next.setOnClickListener(this);
        close.setOnClickListener(this);
        pop.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        pop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        pop.setContentView(view);
        pop.setFocusable(true);
        return pop;
    }

    @Override
    public void onClick(View view) {
        //传值
        SharedPreferences.Editor editor = shared.edit();
        one.setSelected(false);
        two.setSelected(false);
        three.setSelected(false);
        four.setSelected(false);
        five.setSelected(false);
        String str = shared.getString("sex","");
        switch (view.getId()){
            case R.id.setting_back:
                finish();
                break;
            case R.id.ll_setting:
                TranslateAnimation down = new TranslateAnimation(0,0,-200,0);
                //位置
                down.setFillAfter(true);//让动画停在最后一帧
                down.setInterpolator(new BounceInterpolator());//跳动
                down.setDuration(2000);//时间
                llOne.startAnimation(down);
                pop.showAtLocation(view, Gravity.CENTER,0,0);
                break;
            case R.id.popOne_next:
                pop.dismiss();
                popTwo.showAtLocation(view,Gravity.CENTER,0,0);
                break;
            case R.id.img_boy:
                girl.setSelected(false);
                boy.setSelected(true);
                boy.setImageResource(R.drawable.selected_btn);
                girl.setImageResource(R.drawable.unselect_btn);
                editor.putString("sex","男孩");
                editor.apply();
                break;
            case R.id.img_gril:
                girl.setSelected(true);
                boy.setSelected(false);
                boy.setImageResource(R.drawable.unselect_btn);
                girl.setImageResource(R.drawable.selected_btn);
                editor.putString("sex","女孩");
                editor.apply();
                break;
            case R.id.img_close:
                pop.dismiss();
                break;
            case R.id.one:
                one.setSelected(true);
                editor.putString("job","初中生");
                one.setImageResource(R.drawable.selected_btn);
                two.setImageResource(R.drawable.unselect_btn);
                three.setImageResource(R.drawable.unselect_btn);
                four.setImageResource(R.drawable.unselect_btn);
                five.setImageResource(R.drawable.unselect_btn);
                editor.apply();
                break;
            case R.id.two:
                one.setSelected(true);
                editor.putString("job","高中生");
                one.setImageResource(R.drawable.unselect_btn);
                two.setImageResource(R.drawable.selected_btn);
                three.setImageResource(R.drawable.unselect_btn);
                four.setImageResource(R.drawable.unselect_btn);
                five.setImageResource(R.drawable.unselect_btn);
                editor.apply();
                break;
            case R.id.three:
                one.setSelected(true);
                editor.putString("job","大学生");
                one.setImageResource(R.drawable.unselect_btn);
                two.setImageResource(R.drawable.unselect_btn);
                three.setImageResource(R.drawable.selected_btn);
                four.setImageResource(R.drawable.unselect_btn);
                five.setImageResource(R.drawable.unselect_btn);
                editor.apply();
                break;
            case R.id.four:
                one.setSelected(true);
                editor.putString("job","职场新人");
                one.setImageResource(R.drawable.unselect_btn);
                two.setImageResource(R.drawable.unselect_btn);
                three.setImageResource(R.drawable.unselect_btn);
                four.setImageResource(R.drawable.selected_btn);
                five.setImageResource(R.drawable.unselect_btn);
                editor.apply();
                break;
            case R.id.five:
                one.setSelected(true);
                editor.putString("job","资深工作党");
                one.setImageResource(R.drawable.unselect_btn);
                two.setImageResource(R.drawable.unselect_btn);
                three.setImageResource(R.drawable.unselect_btn);
                four.setImageResource(R.drawable.unselect_btn);
                five.setImageResource(R.drawable.selected_btn);
                editor.apply();
                break;
            case R.id.pop_two_close:
                popTwo.dismiss();
                break;
            case R.id.pop_two_back:
                popTwo.dismiss();
                pop.showAtLocation(view,Gravity.CENTER,0,0);
                break;
            case R.id.btn_enter_app:
                tvSex.setText(shared.getString("sex",""));
                tvJob.setText(shared.getString("job",""));
                popTwo.dismiss();
                break;
            case R.id.setting_fl_tel:
                    Intent intent = new Intent();
                    Uri dataU = Uri.parse("tel:4009992053");
                    intent.setData(dataU);
                    startActivity(intent);
                break;

        }
    }
}
