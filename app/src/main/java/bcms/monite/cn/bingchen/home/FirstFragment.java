package bcms.monite.cn.bingchen.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.common.BaseNetListener;
import bcms.monite.cn.bingchen.common.NetUtils;
import bcms.monite.cn.bingchen.config.Constants;
import bcms.monite.cn.bingchen.home.adapter.FirstFragmentSelectAdapter;
import bcms.monite.cn.bingchen.home.adapter.FirstFragmentVideoAdapter;
import bcms.monite.cn.bingchen.home.model.GetHomeSortList;
import bcms.monite.cn.bingchen.home.model.HomeDataList;
import bcms.monite.cn.bingchen.main.BaseFragment;
import butterknife.BindView;

public class FirstFragment extends BaseFragment implements BaseNetListener {

    @BindView(R.id.recycler_head)
    SwipeRecyclerView recycler_head;

    private List<String> selectData = new ArrayList<>();
    private FirstFragmentSelectAdapter selectAdapter;
    private boolean isCreated = false;
    private GetHomeSortList getHomeSortList;
    private View header;
    private RecyclerView recyclerView_head_item;
    private FirstFragmentVideoAdapter fragmentVideoAdapter;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (!isCreated) {
            return;
        }
        if (isVisibleToUser) {

        }
    }

    @Override
    public int createView() {
        return R.layout.main_first_fragment;
    }


    @Override
    public void initViews() {
        isCreated = true;
        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_head.setLayoutManager(manager);

        fragmentVideoAdapter = new FirstFragmentVideoAdapter(getActivity());
        recycler_head.setAdapter(fragmentVideoAdapter);

        addHeaderView();
    }

    private void addHeaderView() {
        header = LayoutInflater.from(getActivity()).inflate(R.layout.home_video_item, null);
        recyclerView_head_item = header.findViewById(R.id.recycler_head_item);
        //设置布局管理器 head
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_head_item.setLayoutManager(linearLayoutManager);

        recycler_head.addHeaderView(header);
        selectAdapter = new FirstFragmentSelectAdapter(getActivity());
        recyclerView_head_item.setAdapter(selectAdapter);
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
                    getHomeSortList = (GetHomeSortList) data;
                    //设置适配器
                    Log.i(TAG, "success: ss" + ((GetHomeSortList) data).getCode());
                    updataTitleList();

                }
                break;
            case "002":
                if (data instanceof HomeDataList) {
                    Log.i(TAG, "success: ss" + ((HomeDataList) data).getCode());
                    HomeDataList homeDataList = (HomeDataList) data;
                    updataVideoList(homeDataList);
                }
                break;

        }

    }

    private void updataVideoList(HomeDataList homeDataList) {
        fragmentVideoAdapter.updateData(homeDataList.getData().getHomeCommendVideoVOList());
    }

    @Override
    public void fail(String flag, String meg) {

    }

    private void updataTitleList() {
        selectAdapter.updateData(getHomeSortList.getData().getVideoKindDicVOList());
    }
}
