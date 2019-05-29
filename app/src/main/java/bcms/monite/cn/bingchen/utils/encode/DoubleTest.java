package bcms.monite.cn.bingchen.utils.encode;

package DoubleEncrypt;

import java.util.Map;
import AES.AESUtil;
import RSA.RSAUtils;
import util.Base64;

/**
 * 双重加密（RSA+AES） AES加密密钥 RSA加密数据
 *
 * @author 微软
 *
 */
public class DoubleTest {

    // AES密码
    static final String password = "123";

    // RSA公钥、密钥
    static String publicKey = "";

    static String privateKey = "";

    static {
        try {
            // 生成公钥、密钥对
            Map<String, Object> map = RSAUtils.getKenPair();
            publicKey = RSAUtils.getPublicKey(map);
            privateKey = RSAUtils.getPrivateKey(map);
            Thread.sleep(100);
            System.out.println("生成公钥：");
            System.err.println(publicKey);
            Thread.sleep(500);
            System.out.println("生成密钥：");
            System.err.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
            String source = "HelloWorld";
            System.out.println("原内容：" + source);
            // 对密钥进性对称加密，这样发给对方时，对方必须解密才可以拿到真正的密钥
            System.out.println("---------------------------AES加密阶段-------------------------------");
            publicKey = new String(AESUtil.encrypt(publicKey, password), "UTF-8");
            System.out.println("AES加密后的公钥：");
            System.err.println(publicKey);
            // 拿我方私钥加密
            byte[] dataBypri = Base64.encode(RSAUtils.encryptedDataByPrivateKey(source.getBytes("UTF-8"), privateKey));
            System.out.println("加密后的内容为：");
            System.err.println(new String(dataBypri, "UTF-8"));
            System.out.println("--------------------------AES解密阶段--------------------------------");
            // 对方拿到公钥后,需要进行AES解密.
            byte[] tempPubs = AESUtil.decrypt(publicKey.getBytes("UTF-8"), password);
            System.out.println("AES解密后的公钥");
            String a = new String(tempPubs, "UTF-8");
            System.err.println(a);
            // Base64解码密文
            byte[] tempBytes = Base64.decode(dataBypri);
            // 根据公钥进行解密
            byte[] dataByPub = RSAUtils.decryptedByPublicKey(tempBytes, a);
            Thread.sleep(100);
            System.out.println("解密后的数据内容为：");
            System.err.println(new String(dataByPub, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
