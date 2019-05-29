package bcms.monite.cn.bingchen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.yanzhenjie.sofia.Sofia;


public class MainActivity extends AppCompatActivity {

    /**
     * RSA  公钥  rsaPublicKey
     * AES  密实  aesKey
     * <p>
     * 加密前 json
     * aesKey 对json进行加密   加密后encruyptData
     * <p>
     * rsaPublicKey对 aesKey进行加密  encryptAesKey
     * <p>
     * encryptAesKey 为请求头 将encruyptData 传输出去
     */
    private String aesKey;
    public final static String ENCODING = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sofia.with(this).statusBarBackground(R.color.colorAccent);
        // 自定义json
        String request = "123456";
        try {
//            aesKey = AESUtils.getAESKey();//
//            //加密后json
//            String encruyptData = AESUtils.aesEncrypt(request, ENCODING, "ECB", aesKey, "");



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
