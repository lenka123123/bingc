package bcms.monite.cn.bingchen.me.model;

/**
 * @author: yuxiaodong
 *
 *
 *
 * date:  2019/6/12.
 */
public class LoginBean {
    /**
     * code : 200
     * data : {"achieveLoveCount":"获赞数量","backgroundImageUrl":"背景图片地址","bcNumber":"缤橙号","birthday":"生日","cityId":"市ID","cityName":"市名称","createTime":"创建时间","createUserId":"创建人","headImageUrl":"头像图片地址","loginPassword":"密码登录密码","mobilePhone":"手机号码手机号码","nickName":"昵称昵称","provinceId":"省ID","provinceName":"省名称","qqOpenId":"QQ开放平台唯一ID","realName":"真实姓名真实姓名","sex":"性别0-保密,1-男,2-女","signature":"签名","token":"token","updateTime":"更新时间","updateUserId":"更新人","userDynamicCount":"动态数量","userFansCount":"粉丝数量","userFocusCount":"关注数量","userId":"用户ID","userLoveCount":"喜欢数量","userVideoCount":"作品数量","weiBoOpenId":"微博开放平台唯一ID","weiXinOpenId":"微信开放平台唯一ID"}
     * message : 请求成功
     */

    private String code;
    private DataBean data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * achieveLoveCount : 获赞数量
         * backgroundImageUrl : 背景图片地址
         * bcNumber : 缤橙号
         * birthday : 生日
         * cityId : 市ID
         * cityName : 市名称
         * createTime : 创建时间
         * createUserId : 创建人
         * headImageUrl : 头像图片地址
         * loginPassword : 密码登录密码
         * mobilePhone : 手机号码手机号码
         * nickName : 昵称昵称
         * provinceId : 省ID
         * provinceName : 省名称
         * qqOpenId : QQ开放平台唯一ID
         * realName : 真实姓名真实姓名
         * sex : 性别0-保密,1-男,2-女
         * signature : 签名
         * token : token
         * updateTime : 更新时间
         * updateUserId : 更新人
         * userDynamicCount : 动态数量
         * userFansCount : 粉丝数量
         * userFocusCount : 关注数量
         * userId : 用户ID
         * userLoveCount : 喜欢数量
         * userVideoCount : 作品数量
         * weiBoOpenId : 微博开放平台唯一ID
         * weiXinOpenId : 微信开放平台唯一ID
         */

        private String achieveLoveCount;
        private String backgroundImageUrl;
        private String bcNumber;
        private String birthday;
        private String cityId;
        private String cityName;
        private String createTime;
        private String createUserId;
        private String headImageUrl;
        private String loginPassword;
        private String mobilePhone;
        private String nickName;
        private String provinceId;
        private String provinceName;
        private String qqOpenId;
        private String realName;
        private String sex;
        private String signature;
        private String token;
        private String updateTime;
        private String updateUserId;
        private String userDynamicCount;
        private String userFansCount;
        private String userFocusCount;
        private String userId;
        private String userLoveCount;
        private String userVideoCount;
        private String weiBoOpenId;
        private String weiXinOpenId;

        public String getAchieveLoveCount() {
            return achieveLoveCount;
        }

        public void setAchieveLoveCount(String achieveLoveCount) {
            this.achieveLoveCount = achieveLoveCount;
        }

        public String getBackgroundImageUrl() {
            return backgroundImageUrl;
        }

        public void setBackgroundImageUrl(String backgroundImageUrl) {
            this.backgroundImageUrl = backgroundImageUrl;
        }

        public String getBcNumber() {
            return bcNumber;
        }

        public void setBcNumber(String bcNumber) {
            this.bcNumber = bcNumber;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getHeadImageUrl() {
            return headImageUrl;
        }

        public void setHeadImageUrl(String headImageUrl) {
            this.headImageUrl = headImageUrl;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getQqOpenId() {
            return qqOpenId;
        }

        public void setQqOpenId(String qqOpenId) {
            this.qqOpenId = qqOpenId;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getUserDynamicCount() {
            return userDynamicCount;
        }

        public void setUserDynamicCount(String userDynamicCount) {
            this.userDynamicCount = userDynamicCount;
        }

        public String getUserFansCount() {
            return userFansCount;
        }

        public void setUserFansCount(String userFansCount) {
            this.userFansCount = userFansCount;
        }

        public String getUserFocusCount() {
            return userFocusCount;
        }

        public void setUserFocusCount(String userFocusCount) {
            this.userFocusCount = userFocusCount;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserLoveCount() {
            return userLoveCount;
        }

        public void setUserLoveCount(String userLoveCount) {
            this.userLoveCount = userLoveCount;
        }

        public String getUserVideoCount() {
            return userVideoCount;
        }

        public void setUserVideoCount(String userVideoCount) {
            this.userVideoCount = userVideoCount;
        }

        public String getWeiBoOpenId() {
            return weiBoOpenId;
        }

        public void setWeiBoOpenId(String weiBoOpenId) {
            this.weiBoOpenId = weiBoOpenId;
        }

        public String getWeiXinOpenId() {
            return weiXinOpenId;
        }

        public void setWeiXinOpenId(String weiXinOpenId) {
            this.weiXinOpenId = weiXinOpenId;
        }
    }
}
