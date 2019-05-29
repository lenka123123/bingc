package AES;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES加密工具类
 *
 * @author 微软
 *
 */
public class AESUtil {

    static final String AES_ENCRYPT = "AES";

    static final String CHARTSETS = "UTF-8";

    /**
     * AES加密
     *
     * @param content
     * @param password
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            // 初始化
            KeyGenerator kgen = KeyGenerator.getInstance(AES_ENCRYPT);
            // 初始化长度，以及密码
            kgen.init(128, new SecureRandom(password.getBytes(CHARTSETS)));
            // 生成key
            SecretKey secretKey = kgen.generateKey();
            // 根据用户密码生成密钥
            byte[] cnCodeFormat = secretKey.getEncoded();
            // 转换为AES密钥
            SecretKeySpec key = new SecretKeySpec(cnCodeFormat, AES_ENCRYPT);
            // 初始化加密器
            Cipher cipher = Cipher.getInstance(AES_ENCRYPT);
            byte[] byteContent = content.getBytes(CHARTSETS);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);// 加密
            // AES加密后的密文必须Base64编码
            return util.Base64.encode(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param content
     * @param password
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            // 初始化
            KeyGenerator kgen = KeyGenerator.getInstance(AES_ENCRYPT);
            // 128长度
            kgen.init(128, new SecureRandom(password.getBytes(CHARTSETS)));
            // 根据密码生成密钥
            SecretKey key = kgen.generateKey();
            byte[] keyContent = key.getEncoded();
            // 转换为AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(keyContent, AES_ENCRYPT);
            // 创建密码器
            Cipher cipher = Cipher.getInstance(AES_ENCRYPT);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            // 将需要解密的内容进行Base64解码
            byte[] result = cipher.doFinal(util.Base64.decode(content));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
