package lanou.gift.search;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.search.test.RecyclerViewSearchAdapter;
import lanou.gift.textbean.SearchBean;
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
    private ListView lv,lvHint;
    private RecyclerView rv;
    private RecyclerViewSearchAdapter adapter;
    private HintListViewAdapter hintAdapter;
    private EditText editText;
    private Button btnSearch;
    private ListViewSearchAdapter lvAdapter;
    private Search search;
    private ArrayList<String> arrayList;
    private ArrayList<SearchBean.DataBean.WordsBean> hintArrayList;
    private List<SearchBean.DataBean.WordsBean> words;

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        btnBack = bindView(R.id.btn_search_title_back);
        lv = bindView(R.id.lv_search);
        rv = bindView(R.id.rv_search);
        editText = bindView(R.id.search_actv);
        btnSearch = bindView(R.id.btn_search_title_search);
        lvHint = bindView(R.id.lv_hint);

        //点击之后显示
        lvHint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(words.get(i).getWord().toString());
                lvHint.setVisibility(View.INVISIBLE);
            }
        });

    }

   @Override
    protected void initData() {

       LiteOrm mLiteOrm = LiteOrm.newSingleInstance(this,"myDB.db");


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
            hintAdapter = new HintListViewAdapter(this);
             hintArrayList = new ArrayList<>();
            editText.addTextChangedListener(watcher);


            //查询
            querySearch();

    }
    //item的点击






    //检索条更改变化
        private TextWatcher watcher = new TextWatcher() {



        @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String content = editText.getText().toString();
                String url = Values.QUERY_SEARCH + content;
                GsonRequest<SearchBean> searchGsonRequest = new GsonRequest<SearchBean>(
                        SearchBean.class, url, new Response.Listener<SearchBean>() {
                    @Override
                    public void onResponse(final SearchBean response) {
                        words = response.getData().getWords();
                        hintAdapter.setArrayList(words);
                        lvHint.setAdapter(hintAdapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                VolleySingleton.getInstance().addRequest(searchGsonRequest);

                //如果是空 隐藏
                if (editText.getText().length() == 0){
                 lvHint.setVisibility(View.INVISIBLE);
                }else{
                    lvHint.setVisibility(View.VISIBLE);
                }


            }
        };

   private void querySearch() {
        //把查询的结果显示在listView上
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
                lv.setAdapter(lvAdapter);

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search_title_back:
                finish();
                break;
            case R.id.btn_search_title_search:
                String str = editText.getText().toString();
                search = new Search();
                search.setThings(editText.getText().toString());
                arrayList.add(str);
                lvAdapter.setArrayList(arrayList);
                lv.setAdapter(lvAdapter);
                DBTool.getInstance().insertSearch(search);
                break;

        }
    }


}
