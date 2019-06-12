package bcms.monite.cn.bingchen.common;

import android.util.Log;

import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.lang.reflect.Type;
import java.util.TreeMap;

import bcms.monite.cn.bingchen.MyApplication;
import bcms.monite.cn.bingchen.home.model.HomeDataList;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NetUtils<T> {

    private static NetUtils instance = new NetUtils();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final Gson gson;

    private NetUtils() {
        gson = new Gson();
    }

    public static NetUtils getInstance() {
        return instance;
    }


    public void post(String url, TreeMap paramsMap, final BaseNetListener listener, final String flag) {

        TreeMap<String, Object> commonParams = new TreeMap<String, Object>();
        commonParams.put("appVersion", CommonUtil.getVersion(MyApplication.mContext));
        commonParams.put("deviceId", CommonUtil.getAndroidId(MyApplication.mContext));
        commonParams.put("deviceSystem", "2");
        commonParams.put("requestId", EnCodeUtils.getInstance().getStringRandom(9));
        commonParams.put("requestTimestamp", TimeUtils.getNowDate());

        paramsMap.put("base", commonParams);
        Log.i("decryptString请求参数====", "postObj: " + gson.toJson(paramsMap));

        TreeMap<String, Object> commonParamss = new TreeMap<String, Object>();
        commonParamss.put("request", AESUtils.encrypt(gson.toJson(paramsMap)));
        final RequestBody requestBody = RequestBody.create(JSON, gson.toJson(commonParamss));

        EasyHttp.post(url)
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)

                .requestBody(requestBody)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        listener.fail(flag, "");

                    }

                    @Override
                    public void onSuccess(String response) {
                        BaseBean data = gson.fromJson(response, BaseBean.class);
                        if (data.getCode().equals("200")) {
                            listener.success(flag, data);
                        } else {
                            // TODO: 2019/6/9 0009
                            listener.fail(flag, "");
                        }
                    }
                });
    }


    public void postObj(String url, TreeMap paramsMap, final BaseNetListener listener,
                        final String flag, final T t) {

        TreeMap<String, Object> commonParams = new TreeMap<String, Object>();
        commonParams.put("appVersion", CommonUtil.getVersion(MyApplication.mContext));
        commonParams.put("deviceId", CommonUtil.getAndroidId(MyApplication.mContext));
        commonParams.put("deviceSystem", "2");
        commonParams.put("requestId", EnCodeUtils.getInstance().getStringRandom(9));
        commonParams.put("requestTimestamp", TimeUtils.getNowDate());

        paramsMap.put("base", commonParams);
        Log.i("decryptString请求参数====", "postObj: " + gson.toJson(paramsMap));
        TreeMap<String, Object> commonParamss = new TreeMap<String, Object>();
        commonParamss.put("request", AESUtils.encrypt(gson.toJson(paramsMap)));
        final RequestBody requestBody = RequestBody.create(JSON, gson.toJson(commonParamss));

        EasyHttp.post(url)
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)

                .requestBody(requestBody)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        listener.fail(flag, "");

                    }

                    @Override
                    public void onSuccess(String response) {
                        T data = gson.fromJson(response, (Class<T>) t);
                        listener.success(flag, data);
//                        if (data.getCode().equals("200")) {
//                            listener.success(flag, data);
//                        } else {
//                         listener.fail(flag, data.getMessage());
//                        }
                    }
                });
    }
}
