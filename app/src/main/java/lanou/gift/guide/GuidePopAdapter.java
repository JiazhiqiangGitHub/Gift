package lanou.gift.guide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.GirlFriend;
import lanou.gift.textbean.TabLayoutBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/4.
 */
public class GuidePopAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private TabLayoutBean bean;
    private Context mContext;
    private GirlFriend itemBean;

    public void setItemBean(GirlFriend itemBean) {
        this.itemBean = itemBean;
    }

    public GuidePopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(TabLayoutBean bean) {
        this.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent,R.layout.pop_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        holder.setText(R.id.tv_guide_pop,bean.getData().getChannels().get(position).getName()).
                setItemClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext,GuideFragment.class);
//                        intent.putExtra("second",itemBean.getData().getItems().get(position).getUrl());
                        mContext.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return bean == null?0:bean.getData().getChannels().size();
    }
}







