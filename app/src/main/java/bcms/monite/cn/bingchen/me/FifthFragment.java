package bcms.monite.cn.bingchen.me;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import bcms.monite.cn.bingchen.main.BaseFragment;
import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.me.activity.EditInfoActivity;
import bcms.monite.cn.bingchen.me.activity.LoginActivity;
import butterknife.OnClick;

public class FifthFragment extends BaseFragment {

    @Override
    public int createView() {
        return R.layout.main_fifth_fragment;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }

    @OnClick({R.id.login_img, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_img:
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(getActivity(), EditInfoActivity.class));
                break;
        }


    }
}
