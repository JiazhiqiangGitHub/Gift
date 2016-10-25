package lanou.gift.hot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;

/**
 * Created by dllo on 16/10/25.
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    ArrayList<HotBean> arrayList;
    private Context mContext;

    public HotAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setArrayList(ArrayList<HotBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public HotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hot_item,parent,false);
        ViewHolder myViewHolder = new ViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HotAdapter.ViewHolder holder, int position) {
        holder.picture.setImageBitmap(arrayList.get(position).getPicture());
        holder.name.setText(arrayList.get(position).getName());
        holder.price.setText(arrayList.get(position).getPrice());
        holder.love.setImageBitmap(arrayList.get(position).getLove());
        holder.people.setText(arrayList.get(position).getPeople());

    }

    @Override
    public int getItemCount() {
        return arrayList == null?0:arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView people;
        private final TextView name;
        private final TextView price;
        private final ImageView picture;
        private final ImageView love;

        public ViewHolder(View itemView) {
            super(itemView);
            people = (TextView) itemView.findViewById(R.id.tv_hot_rv_people);
            name = (TextView) itemView.findViewById(R.id.tv_hot_rv_name);
            price = (TextView) itemView.findViewById(R.id.tv_hot_rv_price);
            picture = (ImageView) itemView.findViewById(R.id.iv_hot_rv_picture);
            love = (ImageView) itemView.findViewById(R.id.iv_hot_rv_love);


        }
    }
}
