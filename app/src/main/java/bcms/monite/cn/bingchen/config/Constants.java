package bcms.monite.cn.bingchen.config;


import android.content.Context;

import bcms.monite.cn.bingchen.MyApplication;

public class Constants {

    /***
     * 首页
     */
    public static final String getCommendVideoList="/home/Feature/getCommendVideoList.action"; // 获取首页推荐部分10个视频





    /**
     * 数值常量
     */
    public static final int TAB_POSITION_HOME = 0;           //首页
    public static final int TAB_POSITION_ZJ = 1;             //踪迹
    public static final int TAB_POSITION_PZ = 2;      //拍照
    public static final int TAB_POSITION_XX = 3;        //消息
    public static final int TAB_POSITION_ME = 4;        //我的


    //requestCode
    public static final int LOGIN_REQUEST_CODE = 13353;       //登录请求码
    public static final int SETTING_REQUEST_CODE = 13354;     //设置请求码
    public static final int SIGN_IN_REQUEST_CODE = 13355;     //签到请求码
    public static final int ASSET_INDEX_REQUEST_CODE = 13356;     //社交资产码

    public static final int NO_TOKEN = 1;                     //请求状态，不带Token
    public static final int WITH_TOKEN = 2;                    //请求状态，需要携带Token
    public static final int LOGIN_WITH_TOKEN = 3;             //请求状态，如果为登录状态则携带Token
}