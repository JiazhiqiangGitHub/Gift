package lanou.gift.hot;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.SearchActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class HotFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton btnSearch;
    private RecyclerView rc;
    Intent intent = null;
    private HotBean bean;
    private ArrayList<HotBean> mArrayList;
    private HotAdapter adapter;

    @Override
    protected void initDate() {


        mArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            bean = new HotBean();
            bean.setName("天然草木制作的手工信纸");
            bean.setPrice("19.00");
            bean.setPeople("675");
            mArrayList.add(bean);
        }
        adapter = new HotAdapter(getActivity());


        adapter.setArrayList(mArrayList);
        rc.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        rc.setLayoutManager(manager);

        btnSearch.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnSearch = bindView(R.id.btn_hot_title_search);
        rc = bindView(R.id.rc_hot);
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_fragment;
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(getActivity(),SearchActivity.class);
        startActivity(intent);
    }



}
