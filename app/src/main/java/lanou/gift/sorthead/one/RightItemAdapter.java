package lanou.gift.sorthead.one;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.activity.OneActivity;
import lanou.gift.textbean.OneBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/1.
 */
public class RightItemAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private Context context;
    private OneBean bean;
    private int i;
    //以为还要获取每个item内部的各个数据 要给个i
    public RightItemAdapter(Context context,int i) {
        this.context = context;
        this.i = i;
    }

    public void setBean(OneBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent,R.layout.one_right_body);
    }
    //这里的i是先去找相应的集合 然后再在集合中找到对应position的数据
    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {

        holder.setText(R.id.tv_one_right_body,bean.getData().getCategories().get(i).getSubcategories().
               get(position).getName()).setImage(R.id.iv_one_right_body,bean.getData().getCategories().get(i).getSubcategories().
                get(position).getIcon_url()).setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //传ID 强转
                int id = bean.getData().getCategories().get(position).getSubcategories().get(position).getId();
                String strId = Integer.toString(id);
                String strTitle = bean.getData().getCategories().get(position).getSubcategories().get(position).getName();
                Intent intent = new Intent(context,OneActivity.class);
                intent.putExtra("strTitle",strTitle);
                intent.putExtra("id",strId);
                context.startActivity(intent);

            }
        });

    }
    //这里集合的数量要注意
    @Override
    public int getItemCount() {
        return bean.getData().getCategories().get(i).getSubcategories().size();
    }
}
