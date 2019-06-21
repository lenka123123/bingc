package bcms.monite.cn.bingchen.common.customview.alertview;

import android.view.View;

import java.util.List;

/**
 * 点击接口
 */
public interface OnItemClickListener {
    public void onItemClick(View view, List<String> mOthers, Object o, int position);
}
