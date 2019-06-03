package bcms.monite.cn.bingchen;

import android.util.Log;

import com.google.gson.JsonObject;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import bcms.monite.cn.bingchen.common.AESUtils;
import bcms.monite.cn.bingchen.config.Constants;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;

import static android.content.ContentValues.TAG;

public class CustomSignInterceptor implements Interceptor {
    private final Charset UTF8 = Charset.forName("UTF-8");
    private JSONObject jsonObject;
    private String key;
    private String decryptString;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        RequestBody requestBody = request.body();

        String body = null;

        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            body = buffer.readString(charset);
        }

        Logger.e("发送请求\nmethod：%s\nurl：%s\nheaders: %sbody：%s",
                request.method(), request.url(), request.headers(), body);
        Log.i(TAG, "intercept: " + request.method());
        Log.i(TAG, "intercept: " + request.url());
        Log.i(TAG, "intercept: " + request.headers());
        Log.i(TAG, "intercept: " + request.body());

        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);


        if (response.body() != null && response.body().contentType() != null) {
            MediaType mediaType = response.body().contentType();
            String responseData = response.body().string();
            Log.d("MediaType--------", mediaType.toString());
            Log.d("MediaType--------", responseData);

            try {
                jsonObject = new JSONObject(responseData);
                key = jsonObject.getString("response");
                Log.d("MediaType--------", jsonObject.getString("response"));
                decryptString = AESUtils.decrypt(key);

                Log.i(TAG, "decryptString==== " + decryptString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ResponseBody responseBody = ResponseBody.create(mediaType, decryptString);
            return response.newBuilder().body(responseBody).build();
        } else {
            return response;
        }
    }

//    Response response = chain.proceed(chain.request());
//
//            Log.d(TAG, "code     =  : " + response.code());
//            Log.d(TAG, "message  =  : " + response.message());
//            Log.d(TAG, "protocol =  : " + response.protocol());
//
//            if (response.body() != null && response.body().contentType() != null) {
//        MediaType mediaType = response.body().contentType();
//        String string = response.body().string();
//        Log.d(TAG, "mediaType =  :  " + mediaType.toString());
//        Log.d(TAG, "string    =  : " + string);
//        ResponseBody responseBody = ResponseBody.create(mediaType, string);
//        return response.newBuilder().body(responseBody).build();
//    } else {
//        return response;
//    }


}
