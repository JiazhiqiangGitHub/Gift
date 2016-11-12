package lanou.gift.hot.together;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.hot.second.HotActivity;
import lanou.gift.textbean.TextHotBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/10/25.
 */

public class HotAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private TextHotBean bean;
    private Context mContext;

    public HotAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(TextHotBean bean) {
        this.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return CommonViewHolder.getViewHolder(parent,R.layout.hot_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        //一顿点找到解析出的相对的东西
            holder.setText(R.id.tv_hot_rv_name,bean.getData().getItems().get(position).getDescription()).
                    setText(R.id.tv_hot_rv_body,bean.getData().getItems().get(position).getName()).
                    setText(R.id.tv_hot_rv_price,bean.getData().getItems().get(position).getPrice()).
                    setText(R.id.tv_hot_rv_people,String.valueOf(bean.getData().getItems().get(position).getFavorites_count())).
                    setImage(R.id.iv_hot_rv_picture,bean.getData().getItems().get(position).getCover_image_url()).
                    setItemClick(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(mContext,HotActivity.class);
                            //第一页的ID
                            int id = bean.getData().getItems().get(position).getId();
                            //强转
                            String strId = Integer.toString(id);
                            intent.putExtra("id",strId);

                            //第二页的webView
                            intent.putExtra("secondHot",bean.getData().getItems().get(position).getUrl());
                            mContext.startActivity(intent);


                        }
                    });

    }

    @Override
    public int getItemCount() {
        return bean.getData().getItems().size();
    }

}
