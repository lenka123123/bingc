package bcms.monite.cn.bingchen.me;

import android.widget.TextView;
import bcms.monite.cn.bingchen.main.BaseFragment;
import bcms.monite.cn.bingchen.R;

public class FifthFragment extends BaseFragment {

    @Override
    public int createView() {
        TextView textView = new TextView(getActivity());
        textView.setText("===");
        return R.layout.main_fifth_fragment;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }
}