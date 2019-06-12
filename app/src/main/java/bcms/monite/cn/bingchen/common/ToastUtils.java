package bcms.monite.cn.bingchen.common;

import android.content.Context;
import android.widget.Toast;

import bcms.monite.cn.bingchen.MyApplication;
import bcms.monite.cn.bingchen.config.Constants;

/**
 * Created by ZhuJie on 2015/11/13.
 *
 */
public class ToastUtils {
    private static ToastUtils mToastUtils;
    private static Toast mToast;




    private ToastUtils() {
        if (null == mToast) {
            mToast = Toast.makeText(MyApplication.mContext, "", Toast.LENGTH_LONG);
        }
    }

    public static ToastUtils getInstance() {
        if (mToastUtils == null) {
            mToastUtils = new ToastUtils();
        }
        return mToastUtils;
    }

    public void showShortToast(String mString) {
        if (mToast == null) {
            return;
        }
        mToast.setText(mString);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showLongToast(String mString) {
        if (mToast == null) {
            return;
        }
        mToast.setText(mString);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }
}
