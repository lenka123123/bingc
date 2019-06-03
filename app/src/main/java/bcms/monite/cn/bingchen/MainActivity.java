package bcms.monite.cn.bingchen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.TreeMap;

import bcms.monite.cn.bingchen.common.AESUtils;
import bcms.monite.cn.bingchen.common.BaseBean;
import bcms.monite.cn.bingchen.common.EnCodeUtils;
import bcms.monite.cn.bingchen.common.RSA;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class MainActivity extends AppCompatActivity {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String TAG = "MainActivity";
    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVZIPpL0+AkYw+jUhgfVi1LqrKvJ16mo4TU8IZzOewyMBTWrCBHdSPLRvpXeSCuN5tW77PTqxP5AC+CVxkYNkddu5DUiAK9mdekjojBgJqxzq2kxx99jXhHaskJzqqlGhJatXq5RoQL7yaO/01xizvoxOMR2EL3Yh5Snp7y2OdlwIDAQAB";
    String head = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            head = RSA.encrypt(AESUtils.CRYPT_KEY, publicKey);
            Log.i(TAG, "generateKeyString head " + head);
        } catch (Exception e) {
            e.printStackTrace();
        }


        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
        paramsSingle.put("mobilePhone", "18851032658");
        Gson gson = new Gson();
        String json = gson.toJson(paramsSingle);
        String params = AESUtils.encrypt(json);


        TreeMap<String, Object> ee = new TreeMap<String, Object>();
        ee.put("request", params);

        String jsonee = gson.toJson(ee);

        RequestBody requestBody = RequestBody.create(JSON, jsonee);


        EasyHttp.post("/my/login/getLoginVerifyCode.action")
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .headers("bc-key", head)
                .requestBody(requestBody)
                .timeStamp(true)
                .execute(new SimpleCallBack<BaseBean>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.i("ApiException", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onSuccess(BaseBean response) {

                    }
                });
    }
}
