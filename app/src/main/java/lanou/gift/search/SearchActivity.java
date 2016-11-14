package lanou.gift.search;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.search.test.RecyclerViewSearchAdapter;
import lanou.gift.textbean.SearchTextBean;
import lanou.gift.values.Values;
import lanou.gift.volley.DBTool;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.Search;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/24.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    private ListView lv;
    private RecyclerView rv;
    private RecyclerViewSearchAdapter adapter;
    private AutoCompleteTextView actv;
    private ArrayList<HashMap<String,String>> list = new ArrayList<>();
    private Button btnSearch;
    private ListViewSearchAdapter lvAdapter;
    private ArrayList<String> arrayList;
    private LiteOrm mLiteOrm;
    private Search search;

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        btnBack = bindView(R.id.btn_search_title_back);
        lv = bindView(R.id.lv_search);
        rv = bindView(R.id.rv_search);
        actv = bindView(R.id.search_actv);
        btnSearch = bindView(R.id.btn_search_title_search);

    }

   @Override
    protected void initData() {

        mLiteOrm = LiteOrm.newSingleInstance(this,"myDB.db");


        arrayList = new ArrayList<>();
        lvAdapter = new ListViewSearchAdapter(this);
        btnSearch.setOnClickListener(this);
        //图标请求数据
        adapter = new RecyclerViewSearchAdapter(this);
        btnBack.setOnClickListener(this);
        GridLayoutManager manager = new GridLayoutManager(this,5);
        rv.setLayoutManager(manager);

        GsonRequest<SearchTextBean> gsonRequest = new GsonRequest<SearchTextBean>(SearchTextBean.class,
                Values.URL_SEARCH_RV, new Response.Listener<SearchTextBean>() {
            @Override
            public void onResponse(SearchTextBean response) {

                adapter.setBean(response);
                rv.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest);


        //检索条
        SimpleAdapter notes = new SimpleAdapter(this,list,R.layout.second,
                new String[]{"brandSearchText","brandName"},
                new int[]{R.id.searchText,R.id.brandName});
        addItem();
        actv.setAdapter(notes);
        //输入一个就显示
        actv.setThreshold(1);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view.findViewById(R.id.brandName);
                actv.setText(tv.getText().toString()+"");
                actv.setSelection(actv.getText().toString().length());
            }
        });
            //查询
            querySearch();
    }
    private void querySearch() {

        DBTool.getInstance().queryAllSearch(new DBTool.OnQueryListener() {
            @Override
            public void onQuery(List<Search> mSearch) {
                arrayList = new ArrayList<>();
                for (int i = 0; i < mSearch.size(); i++) {
                    String str = mSearch.get(i).getThings();
                    arrayList.add(str);
                }
                Collections.reverse(arrayList);//集合倒置
                lvAdapter.setArrayList(arrayList);
                lvAdapter.notifyDataSetChanged();
                lv.setAdapter(lvAdapter);
            }
        });
    }
    //搜索内容
    private void addItem() {
        HashMap<String,String> item;
        item = new HashMap<>();
        item.put("brandSearchText","s");
        item.put("brandName","水杯");
        list.add(item);

        item = new HashMap<>();
        item.put("brandSearchText","s");
        item.put("brandName","水果");
        list.add(item);

        item = new HashMap<>();
        item.put("brandSearchText","s");
        item.put("brandName","水晶项链");
        list.add(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search_title_back:
                finish();
                break;
            case R.id.btn_search_title_search:
                String str = actv.getText().toString();
                search = new Search();
                search.setThings(actv.getText().toString());
                arrayList.add(str);
                lvAdapter.setArrayList(arrayList);
                lv.setAdapter(lvAdapter);
                DBTool.getInstance().insertSearch(search);
                break;

        }
    }

}
