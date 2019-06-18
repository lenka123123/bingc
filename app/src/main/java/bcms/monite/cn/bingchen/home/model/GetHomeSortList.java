package bcms.monite.cn.bingchen.home.model;

import java.util.List;


public class GetHomeSortList {


    /**
     * code : 200
     * data : {"videoKindDicVOList":[{"kindId":12113,"kindName":"热门"}]}
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
        private List<VideoKindDicVOListBean> videoKindDicVOList;

        public List<VideoKindDicVOListBean> getVideoKindDicVOList() {
            return videoKindDicVOList;
        }

        public void setVideoKindDicVOList(List<VideoKindDicVOListBean> videoKindDicVOList) {
            this.videoKindDicVOList = videoKindDicVOList;
        }

        public static class VideoKindDicVOListBean {
            /**
             * kindId : 12113
             * kindName : 热门
             */

            private int kindId;
            private String kindName;

            public int getKindId() {
                return kindId;
            }

            public void setKindId(int kindId) {
                this.kindId = kindId;
            }

            public String getKindName() {
                return kindName;
            }

            public void setKindName(String kindName) {
                this.kindName = kindName;
            }
        }
    }
}
