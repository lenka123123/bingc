package bcms.monite.cn.bingchen.home.model;

import java.util.List;


public class HomeDataList {

    private String code;
    private DataBean data;

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

    public static class DataBean {
        private List<HomeCommendVideoVOListBean> homeCommendVideoVOList;

        public List<HomeCommendVideoVOListBean> getHomeCommendVideoVOList() {
            return homeCommendVideoVOList;
        }

        public void setHomeCommendVideoVOList(List<HomeCommendVideoVOListBean> homeCommendVideoVOList) {
            this.homeCommendVideoVOList = homeCommendVideoVOList;
        }

        public static class HomeCommendVideoVOListBean {
            /**
             * achieveLoveCount : 1111
             * backgroundMusicUrl : http://www.ytmp3.cn/down/44544.mp3
             * userHeadImageUrl : http://pic37.nipic.com/20140113/8800276_184927469000_2.png
             * userId : 1123455
             * userNickName : 张三
             * userVideoId : 123456
             * videoDesc : 这个视频真好看
             * videoPreviewImageUrl : http://pic37.nipic.com/20140113/8800276_184927469000_2.png
             * videoSite : 如家酒店
             * videoSiteIconUrl : http://pic37.nipic.com/20140113/8800276_184927469000_2.png
             * videoUrl : http://pic37.nipic.com/20140113/8800276_184927469000_2.png
             */

            private int achieveLoveCount;
            private String backgroundMusicUrl;
            private String userHeadImageUrl;
            private String userId;
            private String userNickName;
            private String userVideoId;
            private String videoDesc;
            private String videoPreviewImageUrl;
            private String videoSite;
            private String videoSiteIconUrl;
            private String videoUrl;

            public int getAchieveLoveCount() {
                return achieveLoveCount;
            }

            public void setAchieveLoveCount(int achieveLoveCount) {
                this.achieveLoveCount = achieveLoveCount;
            }

            public String getBackgroundMusicUrl() {
                return backgroundMusicUrl;
            }

            public void setBackgroundMusicUrl(String backgroundMusicUrl) {
                this.backgroundMusicUrl = backgroundMusicUrl;
            }

            public String getUserHeadImageUrl() {
                return userHeadImageUrl;
            }

            public void setUserHeadImageUrl(String userHeadImageUrl) {
                this.userHeadImageUrl = userHeadImageUrl;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getUserVideoId() {
                return userVideoId;
            }

            public void setUserVideoId(String userVideoId) {
                this.userVideoId = userVideoId;
            }

            public String getVideoDesc() {
                return videoDesc;
            }

            public void setVideoDesc(String videoDesc) {
                this.videoDesc = videoDesc;
            }

            public String getVideoPreviewImageUrl() {
                return videoPreviewImageUrl;
            }

            public void setVideoPreviewImageUrl(String videoPreviewImageUrl) {
                this.videoPreviewImageUrl = videoPreviewImageUrl;
            }

            public String getVideoSite() {
                return videoSite;
            }

            public void setVideoSite(String videoSite) {
                this.videoSite = videoSite;
            }

            public String getVideoSiteIconUrl() {
                return videoSiteIconUrl;
            }

            public void setVideoSiteIconUrl(String videoSiteIconUrl) {
                this.videoSiteIconUrl = videoSiteIconUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
