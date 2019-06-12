package bcms.monite.cn.bingchen.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.common.BaseNetListener;
import bcms.monite.cn.bingchen.common.NetUtils;
import bcms.monite.cn.bingchen.config.Constants;
import bcms.monite.cn.bingchen.home.adapter.FirstFragmentSelectAdapter;
import bcms.monite.cn.bingchen.home.model.HomeDataList;
import bcms.monite.cn.bingchen.main.BaseFragment;
import butterknife.BindView;

public class FirstFragment extends BaseFragment implements BaseNetListener {

    @BindView(R.id.recycler_head)
    RecyclerView recycler_head;

    private List<String> selectData = new ArrayList<>();
    private FirstFragmentSelectAdapter selectAdapter;

    @Override
    public int createView() {
        return R.layout.main_first_fragment;
    }


    @Override
    public void initViews() {
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_head.setLayoutManager(linearLayoutManager);

        selectData.add("热点");
        selectData.add("美食");
        selectData.add("酒店");
        selectData.add("奇迹");
        selectData.add("热点");
        selectData.add("美食");
        selectData.add("酒店");
        selectData.add("奇迹");
        //设置适配器
        selectAdapter = new FirstFragmentSelectAdapter(getActivity(), selectData);
        recycler_head.setAdapter(selectAdapter);


//  XTabLayout tabLayout = (XTabLayout) findViewById(R.id.xTablayout);

    }

    @Override
    public void loadData() {
        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
        NetUtils.getInstance().postObj(Constants.getCommendVideoList,
                paramsSingle, this, "1001", HomeDataList.class);

    }

    @Override
    public void success(String flag, Object data) {
        if (data instanceof HomeDataList) {
            HomeDataList list = (HomeDataList) data;
//            Log.i(TAG, "success===" + list.getData().getHomeCommendVideoVOList().size());

        }
    }

    @Override
    public void fail(String flag, String meg) {

    }
}
