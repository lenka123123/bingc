package bcms.monite.cn.bingchen.common;

import java.util.Random;

public class EnCodeUtils {
    private static EnCodeUtils instance = new EnCodeUtils();
    private String singleAESKey = "";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVZIPpL0+AkYw+jUhgfVi1LqrKvJ16mo4TU8IZzOewyMBTWrCBHdSPLRvpXeSCuN5tW77PTqxP5AC+CVxkYNkddu5DUiAK9mdekjojBgJqxzq2kxx99jXhHaskJzqqlGhJatXq5RoQL7yaO/01xizvoxOMR2EL3Yh5Snp7y2OdlwIDAQAB";

    private EnCodeUtils() {
    }

    public static EnCodeUtils getInstance() {
        return instance;
    }

    public String getAESKey() {
        if (singleAESKey.endsWith("")) {
            singleAESKey = getStringRandom(16);
        }
        return singleAESKey;
    }

    public void setAESKey() {
        singleAESKey = "";
    }


    public String getHead() {
        try {
            return RSA.encrypt(getAESKey(), publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    //生成随机数字和字母,
    public String getStringRandom(int length) {
        String val = "1234567890123123";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
