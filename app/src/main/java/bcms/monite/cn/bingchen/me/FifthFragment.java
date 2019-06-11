package bcms.monite.cn.bingchen.me;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import bcms.monite.cn.bingchen.main.BaseFragment;
import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.me.activity.LoginActivity;
import butterknife.OnClick;

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

    @OnClick({R.id.login_img})
    public void onClick(View view) {
        getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
