package bcms.monite.cn.bingchen.common;

public interface BaseNetListener<T>  {

    void success(String flag, T data);

    void fail(String flag, String meg);

}
