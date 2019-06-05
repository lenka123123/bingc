package bcms.monite.cn.bingchen.main;

import android.widget.TextView;

import bcms.monite.cn.bingchen.R;

public class ThirdFragment extends BaseFragment {

    @Override
    public int createView() {
        TextView textView=new TextView(getActivity());
        textView.setText("===");
        return R.layout.main_third_fragment;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }
}
