package bcms.monite.cn.bingchen.common;


import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import bcms.monite.cn.bingchen.MyApplication;

/**
 * <p>
 * 参数加密解密工具，不要和DESEncrypt弄混了
 * </p>
 *
 * @author ZhaoHang
 * @date 2017-09-1 11:55
 */
public class AESUtils {


    private static final String AES = "AES";

//    public static final String CRYPT_KEY = MyApplication.aEsKey; //"b7Rr8Zlj8I9U44TP";

    private static final String IV_STRING = "dMitHORyqbeYVE0o";


    /**
     * 加密
     *
     * @param content 加密内容
     * @return 密文
     * @throws Exception e
     */
    public static String encrypt(String content) {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = MyApplication.aEsKey.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // 同样对加密后数据进行 base64 编码
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

            Log.i("Exception,content", "encrypt: " + content);
            Log.i("Exception,content", "encrypt: " + e.getStackTrace());
        }


        return new String(Base64.encode(encryptedBytes, Base64.DEFAULT));
    }

    /**
     * 解密
     *
     * @param content 密文
     * @return 明文
     * @throws Exception e
     */
    public static String decrypt(String content) {
        // base64 解码
        try {
            byte[] encryptedBytes = Base64.decode(content, Base64.DEFAULT);
            byte[] enCodeFormat = MyApplication.aEsKey.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, AES);
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);

            return new String(result, "UTF-8");
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {

            Log.i("Exception,content", "encrypt: " + content);
            Log.i("Exception,content", "encrypt: " + e.getStackTrace());
        }
        return null;
    }

}