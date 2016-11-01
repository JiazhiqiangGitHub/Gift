package lanou.gift.sorthead.one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.OneBean;

/**
 * Created by dllo on 16/11/1.
 */
public class RightItemAdapter extends RecyclerView.Adapter<RightItemAdapter.ViewHolder> {
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
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_right_body,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }
    //这里的i是先去找相应的集合 然后再在集合中找到对应position的数据
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(context).load(bean.getData().getCategories().get(i).getSubcategories().
                get(position).getIcon_url()).into(holder.picture);
        holder.text.setText(bean.getData().getCategories().get(i).getSubcategories().
                get(position).getName());
    }
    //这里集合的数量要注意
    @Override
    public int getItemCount() {
        return bean.getData().getCategories().get(i).getSubcategories().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView picture;
        private  TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.iv_one_right_body);
            text = (TextView) itemView.findViewById(R.id.tv_one_right_body);
        }
    }
}
