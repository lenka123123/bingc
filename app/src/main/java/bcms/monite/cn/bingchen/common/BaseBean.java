package bcms.monite.cn.bingchen.common;


public class BaseBean<T> {


    /**
     * code : 1001
     * message : [mobilePhone must not be null]
     */

    private String code;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
