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
import bcms.monite.cn.bingchen.home.model.GetHomeSortList;
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

    }

    @Override
    public void loadData() {
        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
        NetUtils.getInstance().postObj("/home/Feature/getVideoKindList.action",
                paramsSingle, this, "001", GetHomeSortList.class);


        NetUtils.getInstance().postObj(Constants.getCommendVideoList,
                paramsSingle, this, "002", HomeDataList.class);

    }

    @Override
    public void success(String flag, Object data) {
        Log.i(TAG, "success: ww " + flag);
        switch (flag) {
            case "001":
                if (data instanceof GetHomeSortList) {
                    GetHomeSortList list = (GetHomeSortList) data;
                    //设置适配器
                    Log.i(TAG, "success: ss" + ((GetHomeSortList) data).getCode());
                    selectAdapter = new FirstFragmentSelectAdapter(getActivity(), list.getData().getVideoKindDicVOList());
                    recycler_head.setAdapter(selectAdapter);

                }
                break;
            case "002":
                if (data instanceof HomeDataList) {
                    HomeDataList list = (HomeDataList) data;

                }
                break;

        }

    }

    @Override
    public void fail(String flag, String meg) {

    }
}
