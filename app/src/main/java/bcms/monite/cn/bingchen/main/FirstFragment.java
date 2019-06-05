package bcms.monite.cn.bingchen.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import bcms.monite.cn.bingchen.R;

public class FirstFragment extends BaseFragment {

    @Override
    public int createView() {
        TextView textView=new TextView(getActivity());
        textView.setText("===");
        return R.layout.main_first_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void initViews() {
      //  XTabLayout tabLayout = (XTabLayout) findViewById(R.id.xTablayout);

    }

    @Override
    public void loadData() {

    }
}
