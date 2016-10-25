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


        bean = new HotBean();
        mArrayList = new ArrayList<>();
        mArrayList.add(bean);
        adapter = new HotAdapter(getActivity());

//        HotAsyncTask asyncTask = new HotAsyncTask();
//        asyncTask.execute("http://api.liwushuo.com/v2/items?gender=1&generation=4&limit=50&oddset=0");

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

//    private class HotAsyncTask extends AsyncTask<String,Integer,ArrayList<HotBean>>{
//        @Override
//        protected ArrayList<HotBean> doInBackground(String... params) {
//            try {
//                URL url = new URL(params[0]);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
//                    InputStream is = connection.getInputStream();
//                    InputStreamReader reader = new InputStreamReader(is);
//                    BufferedReader bufferedReader = new BufferedReader(reader);
//                    String line = "";
//                    String result = "";
//                    while((line = bufferedReader.readLine()) != null){
//                        result += line;
//                    }
//                    JSONArray jsonArray = new JSONArray((result));
//                    if(jsonArray != null){
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject object = jsonArray.getJSONObject(i);
//                            HotBean bean = new HotBean();
//                            if (object.has("title")){
//                                bean.setName(object.getString("title"));
//                            }
//                            if (object.has("price")){
//                                bean.setPrice(object.getString("price"));
//                            }
//                            if (object.has("")){
//
//                            }
//                            mArrayList.add(bean);
//                        }
//                    }
//                    bufferedReader.close();
//                    reader.close();
//                    is.close();
//                    connection.disconnect();
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            return mArrayList;
//        }
//
//    }
}
