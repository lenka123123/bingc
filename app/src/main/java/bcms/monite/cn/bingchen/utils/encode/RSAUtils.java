package RSA;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtils {
    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 生成密钥对（公钥和密钥）
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getKenPair() throws Exception {
        // 指定加密算法
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        // 获取密钥对
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 获取公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 获取私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // Base64解码
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        // PKCS编码对象
        PKCS8EncodedKeySpec pkcs8Encode = new PKCS8EncodedKeySpec(keyBytes);
        // 算法工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 密钥对象
        PrivateKey privateKeyObj = keyFactory.generatePrivate(pkcs8Encode);
        // 数字签名对象
        Signature signture = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 密钥签名
        signture.initSign(privateKeyObj);
        // 加密
        signture.update(data);
        return Base64.encodeBase64String(signture.sign());
    }

    /**
     * 用公钥校验签名
     *
     * @param data
     * @param publicKey
     * @param sign
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        // 解码
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        // X509编码对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // 算法工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 公钥对象
        PublicKey publicKeyObj = keyFactory.generatePublic(keySpec);
        // 数字签名对象
        Signature signture = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 公钥初始化
        signture.initVerify(publicKeyObj);
        signture.update(data);
        return signture.verify(Base64.decodeBase64(sign));
    }

    /**
     * 私钥解密
     *
     * @param encryptedData
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] decryptedByPirvateKey(byte[] encryptedData, String privateKey) throws Exception {
        // Base64解码
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        // PKCS8编码对象
        PKCS8EncodedKeySpec pkcs8EncodeSpec = new PKCS8EncodedKeySpec(keyBytes);
        // 算法工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8EncodeSpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据进行分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decrytedData = out.toByteArray();
        out.close();
        return decrytedData;
    }

    /**
     * 公钥解密
     *
     * @param encryptedData
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static byte[] decryptedByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        // Base64解码
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        // X509编码对象
        X509EncodedKeySpec x509EncodeSpec = new X509EncodedKeySpec(keyBytes);
        // 算法工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 公钥key
        Key publicKeyObj = keyFactory.generatePublic(x509EncodeSpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKeyObj);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = encryptedData.length;
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 公钥加密
     *
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static byte[] encryptedDataByPublicKey(byte[] data, String publicKey) throws Exception {
        // 解码
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKeyObj = keyFactory.generatePublic(x509);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKeyObj);
        int inputLen = data.length;
        int offset = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int i = 0;
        byte[] cache;
        // 对数据进行分段加密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 私钥加密
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] encryptedDataByPrivateKey(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8Spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKeyObj = keyFactory.generatePrivate(pkcs8Spec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKeyObj);
        int inputLen = data.length;
        int offset = 0;
        int i = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] cache;
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 获取私钥
     *
     * @param map
     * @return
     */
    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        Key key = (Key) map.get(PRIVATE_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

    /**
     * 获取公钥
     *
     * @param map
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> map) throws Exception {
        Key key = (Key) map.get(PUBLIC_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

}

