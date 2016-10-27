package lanou.gift.sorthead.one;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/10/25.
 */
public class OneFragment extends BaseFragment {
    private ListView leftListView;
    private StickyListHeadersListView rightListView;
    private RightAdapter rightAdapter;
    private LeftAdapter leftAdapter;
    private ArrayList<String> headlist,bodylist;




    @Override
    protected void initDate() {
        rightAdapter = new RightAdapter(getActivity());
        leftAdapter = new LeftAdapter(getActivity());

        headlist = new ArrayList<>();
        bodylist = new ArrayList<>();

       //假数据
        for (int i = 0; i < 40; i++) {
            headlist.add("情趣用品"+i);
            bodylist.add("充气小娃娃"+i);
        }
        leftAdapter.setList(headlist);
        rightAdapter.setHeadlist(headlist);

        rightAdapter.setBodylist(bodylist);

        leftListView.setAdapter(leftAdapter);
        rightListView.setAdapter(rightAdapter);

        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                rightListView.setSelection(i);


            }
        });

        rightListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                leftListView.smoothScrollToPositionFromTop(i,0);
            }
        });


    }


    @Override
    protected void initView() {
        leftListView = bindView(R.id.lv_class_one_left);
        rightListView = bindView(R.id.lv_class_one_right);
    }

    @Override
    protected int getLayout() {
        return R.layout.class_fragment_one_item;
    }
}
