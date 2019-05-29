package bcms.monite.cn.bingchen.utils.encode;


public class Base64 {

    static final String chartset = "UTF-8";

    /**
     * 编码
     *
     * @param content
     * @return
     */
    public static byte[] encode(byte[] content) {
        byte[] cons = null;
        try {
            cons = org.apache.commons.codec.binary.Base64.encodeBase64(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

    /**
     * 解码
     *
     * @param content
     * @return
     */
    public static byte[] decode(byte[] content) {
        byte[] cons = null;
        try {
            cons = org.apache.commons.codec.binary.Base64.decodeBase64(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
}
