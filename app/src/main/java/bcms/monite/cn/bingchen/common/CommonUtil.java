package bcms.monite.cn.bingchen.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.UUID;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by ${wjw} on 2016/5/5.
 */
public class CommonUtil {
    /**
     * @param V 设置下划线
     */
    public static void setFlags(TextView V) {
        V.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        V.getPaint().setAntiAlias(true);//抗锯齿
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 隐藏软键盘
     */
    public static void hideSoftInput(InputMethodManager mInputMethodManager, View view) {
        mInputMethodManager
                .hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 显示软键盘
     */
    public static void showSoftInput(InputMethodManager mInputMethodManager, View view) {
        mInputMethodManager
                .showSoftInput(view, 0);
    }


    private static long lastClickTime = 0;

    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 复制文本到剪切板
     *
     * @param text 文本
     */
    public static void copy(Activity aty, String text) {

        ClipboardManager clipboard = (ClipboardManager) aty.getSystemService(Context
                .CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText(null, text);
        clipboard.setPrimaryClip(clip);
    }

    /**
     * 获取人气显示 默认保留后四位
     *
     * @param popularity
     * @return
     */
    public static String popularity(int popularity) {
        if (popularity < 10000) {
            return String.valueOf(popularity);
        } else {
            double popularityD = (double) popularity / 10000;
            BigDecimal b = new BigDecimal(popularityD);
            double d = b.setScale(4, BigDecimal.ROUND_DOWN).doubleValue();
            return new StringBuilder().append(d).append("万").toString();
        }
    }

    /**
     * 保留两位小数
     *
     * @param popularity
     * @return
     */
    public static String popularityTwo(Double popularity) {
        BigDecimal b = new BigDecimal(popularity);
        double d = b.setScale(2, BigDecimal.ROUND_UP).doubleValue();
        return new StringBuilder().append(d).toString();
    }

    /**
     * 保留两位小数
     *
     * @return
     */
    public static String popularityTwoDou(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(b1.multiply(b2).doubleValue());
        return result;
    }

    /**
     * 保留两位小数
     *
     * @return
     */
    public static String popularityFourDou(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        DecimalFormat df = new DecimalFormat("0.0000");
        String result = df.format(b1.multiply(b2).doubleValue());
        return result;
    }

    /**
     * 保留两位小数
     *
     * @return
     */
    public static Double popularityPrice(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    //  f=  "0.00"
    public static String formatDouble(String f, Double d) {
        DecimalFormat df = new DecimalFormat(f);
        return df.format(d);
    }

    /**
     * 获取数据显示 保留小数点后一位
     *
     * @return
     */
    public static String popularityOne(String sPopularity) {
        float popularity = 0;
        try {
            popularity = Float.valueOf(sPopularity);
            if (popularity < 10000) {
                return sPopularity;
            } else if (popularity > 10000 && popularity < 100000000) {
                double popularityD = (double) popularity / 10000;
                BigDecimal b = new BigDecimal(popularityD);
                double d = b.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
                return new StringBuilder().append(d).append("万").toString();
            } else {
                double popularityD = (double) popularity / 100000000;
                BigDecimal b = new BigDecimal(popularityD);
                double d = b.setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
                return new StringBuilder().append(d).append("亿").toString();
            }
        } catch (NumberFormatException e) {
            return "0";
        }
    }

    /**
     * 判断str1中包含str2的个数
     *
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, char str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2) {
                count++;
            }
        }
        return count;
    }


    /*计算最大页数*/
    public static int getMaxPage(int count, int perpage) {
        if (perpage == 0) {
            return 1;
        } else {
            return count % perpage == 0 ? count / perpage : count / perpage + 1;
        }
    }


    public static String getWlanId(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(context.getApplicationContext().WIFI_SERVICE);
        String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
        return m_szWLANMAC;
    }

//    public static String getAndroidId(Context context) {
//            TelephonyManager  telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//            String deviceId = telephonyManager.getDeviceId();
//            if (deviceId==null){
//                //android.provider.Settings;
//                deviceId= Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
//            }
//            return deviceId;
//        }


    //获得独一无二的Psuedo ID
    public static String getAndroidId(Context context) {
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +

                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +

                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +

                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +

                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +

                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +

                Build.USER.length() % 10; //13 位

        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();

    }

}
