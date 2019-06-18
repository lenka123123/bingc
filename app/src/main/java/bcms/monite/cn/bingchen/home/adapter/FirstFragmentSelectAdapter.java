package bcms.monite.cn.bingchen.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.home.model.GetHomeSortList;

public class FirstFragmentSelectAdapter extends RecyclerView.Adapter<FirstFragmentSelectAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<GetHomeSortList.DataBean.VideoKindDicVOListBean>  mDatas = null;

    public FirstFragmentSelectAdapter(Context context,List<GetHomeSortList.DataBean.VideoKindDicVOListBean>  data) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        TextView mTxt;
    }

    public void updateData(List<GetHomeSortList.DataBean.VideoKindDicVOListBean>   data) {
        if (mDatas != null) {
            mDatas.clear();
        }
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.home_fragment_select_item,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mTxt = view
                .findViewById(R.id.name);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.mTxt.setText(mDatas.get(i).getKindName());
    }
}
