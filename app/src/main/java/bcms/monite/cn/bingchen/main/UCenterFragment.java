package bcms.monite.cn.bingchen.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.config.BaseFragment;

public class UCenterFragment extends BaseFragment {

    @Override
    public int createView() {
        TextView textView=new TextView(getActivity());
        textView.setText("===");
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {

    }
}
