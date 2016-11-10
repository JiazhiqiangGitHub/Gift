package lanou.gift.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.SearchTextBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/9.
 */
public class RecyclerViewSearchAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private SearchTextBean bean;
    private Context context;

    public RecyclerViewSearchAdapter(Context context) {
        this.context = context;
    }

    public void setBean(SearchTextBean bean) {
        this.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return CommonViewHolder.getViewHolder(parent, R.layout.item_search);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {

        if (position < 3) {
            holder.setText(R.id.tv_search_item_two, bean.getData().getHot_words().get(position));

        } else {
            holder.setText(R.id.tv_search_item, bean.getData().getHot_words().get(position));
        }
        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = bean.getData().getHot_words().get(position);
                Intent intent = new Intent(context, SearchSecondActivity.class);
                intent.putExtra("search", str);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.getData().getHot_words().size();
    }
}
