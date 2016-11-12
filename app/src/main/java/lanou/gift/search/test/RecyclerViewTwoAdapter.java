package lanou.gift.search.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.SearchTwoBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/10.
 */
public class RecyclerViewTwoAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private SearchTwoBean bean;
    private Context context;

    public RecyclerViewTwoAdapter(Context context) {
        this.context = context;
    }

    public void setBean(SearchTwoBean bean) {
        this.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.search_three);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {

        holder.setImage(R.id.iv_search_three, bean.getData().getItems().get(position).getCover_image_url()).
                setText(R.id.tv_search_three_name, bean.getData().getItems().get(position).getName()).
                setText(R.id.tv_search_three_body, bean.getData().getItems().get(position).getDescription()).
                setText(R.id.tv_search_three_price, bean.getData().getItems().get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getData().getItems().size();
    }
}
