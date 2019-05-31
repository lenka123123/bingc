package bcms.monite.cn.bingchen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.io.IOException;
import java.util.logging.Logger;

import bcms.monite.cn.bingchen.config.Constants;
import bcms.monite.cn.bingchen.util.AES;
import bcms.monite.cn.bingchen.util.ConvertUtils;
import bcms.monite.cn.bingchen.util.RSA;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivityaaa extends AppCompatActivity {

    // /my/login/getLoginVerifyCode.action
    String url = "http://bcms.monite.cn:9999/my/login/getLoginVerifyCode.action";

    String aesKey = Constants.aesKey;
    String json = "CmGWbrB3pxWhj7FsSLG3X4wcA+6qPY7eH42CPyrkbVh9ID8y11yT+FiaRr9XpilKasojXR8MK3UhciVJ73VzIqXy9AFm8nJzSvAC/Dv2/EE0CZt3xuYWa6ZeCS6U1BCb8XLh8ev0M2DDioXAseyQt8qKSOl//eyh9DYclenH8KHM4BiwO/4xHoipNdjYo3Vmqs8vpqF38XCXm/30pxvO5/yFdSN6cCPQvR5kbdNUOKQ7kv8oivoM3lUADXcX/U2mTCq6ZEL/zCK2DIYvnM0SBnvfbo+Z2qmncL4ICHn0AJV1nVtMFT21HlwzCHiZtagN";

    private final String qichengpublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVZIPpL0+AkYw+jUhgfVi1LqrKvJ16mo4TU8IZzOewyMBTWrCBHdSPLRvpXeSCuN5tW77PTqxP5AC+CVxkYNkddu5DUiAK9mdekjojBgJqxzq2kxx99jXhHaskJzqqlGhJatXq5RoQL7yaO/01xizvoxOMR2EL3Yh5Snp7y2OdlwIDAQAB";
    private String encryptkey;
    private String json1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        // 准备头   RSA加密
//        // 使用RSA算法将商户自己随机生成的AESkey加密
//        try {
//            // 使用RSA算法将商户自己随机生成的AESkey加密
//            encryptkey = RSA.encrypt(qichengpublicKey,aesKey);
//
//
//            String postData = "{\"phone\": \"18851032658\"}";
//            //AES加密数据
//            String data = AES.encryptToBase64(postData, aesKey);
//            json1 = "{\"request\": \"" + data + "\"}";
//
//            Log.i("setContentView", "onCreate: " + encryptkey);
//            Log.i("setContentView", "onCreate: " + data);
//            Log.i("setContentView", "onCreate: " + json1);
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    testInterceptor();
//                }
//            }).start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//



    }


    public void testInterceptor() {
        Log.i(" testInterceptor", "testInterceptor:  "+json1);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json1);

        EasyHttp.post("/my/login/getLoginVerifyCode.action")
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .requestBody( body  )
                .timeStamp(true)
                .execute(new SimpleCallBack<Object>() {
                    @Override
                    public void onError(ApiException e) {
                        Log.i("=====SimpleCallBack ===", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onSuccess(Object response) {

                            Log.i("=====SimpleCa===", "onSuccess: " + response.toString());
                    }
                });

//
//        Interceptor loggingInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//
//                //我这里参考的是官网的，你也可以定义里自己的打印方式
//                long t1 = System.nanoTime();
//
//                Response response = chain.proceed(request);
//                long t2 = System.nanoTime();
//                Log.i("intercept", "intercept:  " + response.message());
//                // logger.info(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
//                return response;
//
//            }
//        };
//        //1、创建OkHttpClient实例对象
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
////                .addNetworkInterceptor(new FakeApiInterceptor()) // 添加网络拦截器
//                .build();
//        //2、创建Request实例对象
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        String json = "CmGWbrB3pxWhj7FsSLG3X4wcA+6qPY7eH42CPyrkbVh9ID8y11yT+FiaRr9XpilKasojXR8MK3UhciVJ73VzIqXy9AFm8nJzSvAC/Dv2/EE0CZt3xuYWa6ZeCS6U1BCb8XLh8ev0M2DDioXAseyQt8qKSOl//eyh9DYclenH8KHM4BiwO/4xHoipNdjYo3Vmqs8vpqF38XCXm/30pxvO5/yFdSN6cCPQvR5kbdNUOKQ7kv8oivoM3lUADXcX/U2mTCq6ZEL/zCK2DIYvnM0SBnvfbo+Z2qmncL4ICHn0AJV1nVtMFT21HlwzCHiZtagN";
//
//        RequestBody body = RequestBody.create(JSON, json1);
//
////        RequestBody bodyaaa = new FormBody.Builder()
////                .add("bookid", )
////                .add("bookName",mBookNameEdit.getText().toString()).build();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .addHeader("bc-key", encryptkey)
//                .post(body)
//                .build();
//        //3、使用client执行request请求
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//
//
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public class FakeApiInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response;
            if (BuildConfig.DEBUG && chain.request().url().toString().equals(url)) {
                String json = "CmGWbrB3pxWhj7FsSLG3X4wcA+6qPY7eH42CPyrkbVh9ID8y11yT+FiaRr9XpilKasojXR8MK3UhciVJ73VzIqXy9AFm8nJzSvAC/Dv2/EE0CZt3xuYWa6ZeCS6U1BCb8XLh8ev0M2DDioXAseyQt8qKSOl//eyh9DYclenH8KHM4BiwO/4xHoipNdjYo3Vmqs8vpqF38XCXm/30pxvO5/yFdSN6cCPQvR5kbdNUOKQ7kv8oivoM3lUADXcX/U2mTCq6ZEL/zCK2DIYvnM0SBnvfbo+Z2qmncL4ICHn0AJV1nVtMFT21HlwzCHiZtagN";
                response = new Response.Builder()
                        .code(2000)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("bc-key", "0BA0FB1D22210A5328D95834D70DE155EB5163C7E517BB4897C68BC9C4EA9B5B3560E78FD6F9A5E8CC6C8BAC36ED578C351E1E20F79236A6B7D9B7966ADF148E5BF4BCFA7C7B07CEBA6B5360353742C8ACDEB6E17755A0DE3F5C7C5983429819A50DE680C8B66346A4BE5AFC2EE936198F578D26AF3F0DA7715123C140F084BC")
                        .body(ResponseBody.create(MediaType.parse("application/json"), json))
                        .message(json)
                        .request(chain.request())
                        .protocol(Protocol.HTTP_2)
                        .build();
            } else {
                response = chain.proceed(chain.request());
            }
            Log.i("response", "intercept: " + response.message());
            return response;
        }
    }
}
