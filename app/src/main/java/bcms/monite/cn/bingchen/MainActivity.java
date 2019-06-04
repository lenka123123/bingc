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
import bcms.monite.cn.bingchen.common.BaseNetListener;
import bcms.monite.cn.bingchen.common.NetUtils;
import bcms.monite.cn.bingchen.common.RSA;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements BaseNetListener {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String TAG = "MainActivity";
    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVZIPpL0+AkYw+jUhgfVi1LqrKvJ16mo4TU8IZzOewyMBTWrCBHdSPLRvpXeSCuN5tW77PTqxP5AC+CVxkYNkddu5DUiAK9mdekjojBgJqxzq2kxx99jXhHaskJzqqlGhJatXq5RoQL7yaO/01xizvoxOMR2EL3Yh5Snp7y2OdlwIDAQAB";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TreeMap<String, Object> paramsSingle = new TreeMap<String, Object>();
        paramsSingle.put("mobilePhone", "18851032654");

        NetUtils.getInstance().post("/my/login/getLoginVerifyCode.action",
                paramsSingle, this, "getLoginVerifyCodewwwwwwww");


    }

    @Override
    public void success(String flag, BaseBean data) {
        Log.i("ApiException", "success: " + flag);
        Log.i("ApiException", "success: " + data);
    }

    @Override
    public void fail(String flag, String msg) {
        Log.i("ApiException", "onError: " + flag);
        Log.i("ApiException", "onError: " + msg);
    }
}
