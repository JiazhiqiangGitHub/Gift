package lanou.gift.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/3.
 */
public class OneActivityAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private Context context;

    public OneActivityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.activity_one_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
