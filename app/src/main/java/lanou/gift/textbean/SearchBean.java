package lanou.gift.textbean;

import java.util.List;

/**
 * Created by dllo on 16/11/17.
 */
public class SearchBean {

    /**
     * code : 200
     * data : {"words":[{"cnt":1,"word":"碗盘子"},{"cnt":1,"word":"硅胶文具盒"},{"cnt":130,"word":"破洞牛仔"},{"cnt":29,"word":"研究所"},{"cnt":1,"word":"矮个子女生"},{"cnt":1,"word":"短款钱包女生"},{"cnt":236,"word":"短T"},{"cnt":5,"word":"睡衣公主"},{"cnt":9,"word":"睡眠耳机"},{"cnt":8,"word":"睡眠耳塞"},{"cnt":1,"word":"睡了吗摘颗星星给你"},{"cnt":1199,"word":"眼静"},{"cnt":1,"word":"真花干花书签"},{"cnt":3,"word":"直发夹板"},{"cnt":130,"word":"盖浇"},{"cnt":23,"word":"盆子"},{"cnt":17,"word":"皮鞋单鞋"},{"cnt":1,"word":"皮绳捆绑"},{"cnt":3,"word":"百乐门"},{"cnt":1,"word":"百乐可擦式彩色自动铅笔"},{"cnt":1,"word":"白色花边袜"},{"cnt":5,"word":"白色双肩包"},{"cnt":3,"word":"白纸本"},{"cnt":9,"word":"登机箱"},{"cnt":9,"word":"男项链"}]}
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
         * cnt : 1
         * word : 碗盘子
         */

        private List<WordsBean> words;

        public List<WordsBean> getWords() {
            return words;
        }

        public void setWords(List<WordsBean> words) {
            this.words = words;
        }

        public static class WordsBean {
            private int cnt;
            private String word;

            public int getCnt() {
                return cnt;
            }

            public void setCnt(int cnt) {
                this.cnt = cnt;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }
        }
    }
}
