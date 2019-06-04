package bcms.monite.cn.bingchen.common;

import android.util.Log;

import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NetUtils {

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
        commonParams.put("request", AESUtils.encrypt(gson.toJson(paramsMap)));
        final RequestBody requestBody = RequestBody.create(JSON, gson.toJson(commonParams));

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
                            listener.fail(flag, data.getMessage());
                        }
                    }
                });
    }
}
