package lanou.gift.textbean;

import java.util.List;

/**
 * Created by dllo on 16/11/2.
 */
public class TabLayoutBean {

    /**
     * code : 200
     * data : {"candidates":[{"editable":true,"id":121,"name":"数码","url":""},{"editable":true,"id":111,"name":"礼物","url":""},{"editable":true,"id":118,"name":"美食","url":""},{"editable":true,"id":26,"name":"送基友","url":""},{"editable":true,"id":10,"name":"送女票","url":""},{"editable":true,"id":5,"name":"送闺蜜","url":""},{"editable":true,"id":6,"name":"送爸妈","url":""},{"editable":true,"id":126,"name":"奇葩搞怪","url":""},{"editable":true,"id":125,"name":"创意生活","url":""},{"editable":true,"id":14,"name":"文艺风","url":""},{"editable":true,"id":11,"name":"萌萌哒","url":""},{"editable":true,"id":127,"name":"设计感","url":""},{"editable":true,"id":124,"name":"爱读书","url":""},{"editable":true,"id":122,"name":"爱动漫","url":""},{"editable":true,"id":28,"name":"科技范","url":""}],"channels":[{"editable":false,"id":108,"name":"精选"},{"editable":true,"id":121,"name":"数码","url":""},{"editable":true,"id":111,"name":"礼物","url":""},{"editable":true,"id":118,"name":"美食","url":""},{"editable":true,"id":26,"name":"送基友","url":""},{"editable":true,"id":10,"name":"送女票","url":""},{"editable":true,"id":5,"name":"送闺蜜","url":""},{"editable":true,"id":6,"name":"送爸妈","url":""},{"editable":true,"id":126,"name":"奇葩搞怪","url":""},{"editable":true,"id":125,"name":"创意生活","url":""},{"editable":true,"id":14,"name":"文艺风","url":""},{"editable":true,"id":11,"name":"萌萌哒","url":""},{"editable":true,"id":127,"name":"设计感","url":""},{"editable":true,"id":124,"name":"爱读书","url":""},{"editable":true,"id":122,"name":"爱动漫","url":""},{"editable":true,"id":28,"name":"科技范","url":""}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
         * editable : true
         * id : 121
         * name : 数码
         * url :
         */

        private List<CandidatesBean> candidates;
        /**
         * editable : false
         * id : 108
         * name : 精选
         */

        private List<ChannelsBean> channels;

        public List<CandidatesBean> getCandidates() {
            return candidates;
        }

        public void setCandidates(List<CandidatesBean> candidates) {
            this.candidates = candidates;
        }

        public List<ChannelsBean> getChannels() {
            return channels;
        }

        public void setChannels(List<ChannelsBean> channels) {
            this.channels = channels;
        }

        public static class CandidatesBean {
            private boolean editable;
            private int id;
            private String name;
            private String url;

            public boolean isEditable() {
                return editable;
            }

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ChannelsBean {
            private boolean editable;
            private int id;
            private String name;

            public boolean isEditable() {
                return editable;
            }

            public void setEditable(boolean editable) {
                this.editable = editable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
