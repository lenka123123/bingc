package bcms.monite.cn.bingchen.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import bcms.monite.cn.bingchen.R;
import bcms.monite.cn.bingchen.home.model.GetHomeSortList;
import bcms.monite.cn.bingchen.home.model.HomeDataList;

public class FirstFragmentVideoAdapter extends RecyclerView.Adapter<FirstFragmentVideoAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<HomeDataList.DataBean.HomeCommendVideoVOListBean> mDatas = new ArrayList<>();

    public FirstFragmentVideoAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        ImageView logo;
        TextView title;
        ImageView video_img;
        TextView dz_tv;
        TextView pl_tv;
    }

    public void updateData(List<HomeDataList.DataBean.HomeCommendVideoVOListBean> data) {

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
        View view = mInflater.inflate(R.layout.home_video_item_info,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.logo = view.findViewById(R.id.logo);
        viewHolder.title = view.findViewById(R.id.title);
        viewHolder.video_img = view.findViewById(R.id.video_img);
        viewHolder.dz_tv = view.findViewById(R.id.dz_tv);
        viewHolder.pl_tv = view.findViewById(R.id.pl_tv);

        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(mDatas.get(i).getUserNickName());
        Picasso.with(context).load(mDatas.get(i).getUserHeadImageUrl()).into(viewHolder.logo);
        Picasso.with(context).load(mDatas.get(i).getVideoPreviewImageUrl()).into(viewHolder.video_img);
        viewHolder.dz_tv.setText(mDatas.get(i).getAchieveLoveCount()+"W");

//        viewHolder.pl_tv = view.findViewById(R.id.pl_tv);


    }
}
