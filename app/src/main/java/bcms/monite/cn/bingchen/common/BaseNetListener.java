package bcms.monite.cn.bingchen.common;

public interface BaseNetListener  {

    void success(String flag, BaseBean data);

    void fail(String flag, String meg);

}
