package lanou.gift.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.activity.EnterActivity;
import lanou.gift.activity.SettingActivity;


/**
 * Created by dllo on 16/10/21.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    private RadioButton btnCart, btnOrder, btnCoupon, btnService;
    private ImageButton btnSex, btnSetting;
    Intent intent = null;

    @Override
    protected void initDate() {
        btnService.setOnClickListener(this);
        btnCart.setOnClickListener(this);
        btnCoupon.setOnClickListener(this);
        btnOrder.setOnClickListener(this);
        btnSex.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnCart = bindView(R.id.btn_mine_cart);
        btnOrder = bindView(R.id.btn_mine_order);
        btnCoupon = bindView(R.id.btn_mine_coupon);
        btnService = bindView(R.id.btn_mine_service);
        btnSex = bindView(R.id.iv_mine_boy);
        btnSetting = bindView(R.id.btn_mine_settings);
    }

    @Override
    protected int getLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_mine_cart:
                intent = new Intent(getActivity(), EnterActivity.class);

                break;
            case R.id.btn_mine_order:
                intent = new Intent(getActivity(), EnterActivity.class);

                break;
            case R.id.btn_mine_coupon:
                intent = new Intent(getActivity(), EnterActivity.class);

                break;
            case R.id.btn_mine_service:
                intent = new Intent(getActivity(), EnterActivity.class);

                break;
            case R.id.iv_mine_boy:
                intent = new Intent(getActivity(), EnterActivity.class);

                break;
            case R.id.btn_mine_settings:
                intent = new Intent(getActivity(), SettingActivity.class);

                break;
        }
        startActivity(intent);
    }
}
