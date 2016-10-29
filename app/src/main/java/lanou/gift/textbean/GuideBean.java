package lanou.gift.textbean;

import java.util.List;

/**
 * Created by dllo on 16/10/29.
 */
public class GuideBean {

    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":760,"image_url":"http://img03.liwushuo.com/image/161028/bm7f1orxy.jpg-w720","order":804,"status":0,"target_id":1046281,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1046281","type":"post","webp_url":"http://img03.liwushuo.com/image/161028/bm7f1orxy.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":757,"image_url":"http://img02.liwushuo.com/image/161027/lqle0mmu6.jpg-w720","order":803,"status":0,"target_id":1046309,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1046309","type":"post","webp_url":"http://img02.liwushuo.com/image/161027/lqle0mmu6.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":761,"image_url":"http://img01.liwushuo.com/image/161028/v577ul0un.jpg-w720","order":802,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/161021/k5yc5yvo0.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/161021/k5yc5yvo0.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/161021/bv0dcul8j.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161021/bv0dcul8j.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1477012261,"id":366,"posts_count":10,"status":1,"subtitle":"双11美食会场","title":"双11美食预售会场","updated_at":1477647475},"target_id":366,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=366","type":"collection","webp_url":"http://img01.liwushuo.com/image/161028/v577ul0un.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":755,"image_url":"http://img01.liwushuo.com/image/161027/jlw86rxck.jpg-w720","order":801,"status":0,"target":{"banner_image_url":"http://img01.liwushuo.com/image/161021/77c3mpx3k.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/161021/77c3mpx3k.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/161021/0now2efep.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161021/0now2efep.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1477012358,"id":373,"posts_count":19,"status":1,"subtitle":"口碑超好的护肤品推荐，性价比才是王道","title":"双11美妆+护肤预售会场","updated_at":1477648876},"target_id":373,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=373","type":"collection","webp_url":"http://img01.liwushuo.com/image/161027/jlw86rxck.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":759,"image_url":"http://img02.liwushuo.com/image/161027/t21sqabnw.jpg-w720","order":780,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/161021/a4of3qe26.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/161021/a4of3qe26.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/161021/iqrbz73bx.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/161021/iqrbz73bx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1477012288,"id":370,"posts_count":9,"status":1,"subtitle":"平时买肉疼，现在不买等什么呢？","title":"双11-女装预售会场","updated_at":1477649609},"target_id":370,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=370","type":"collection","webp_url":"http://img02.liwushuo.com/image/161027/t21sqabnw.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":756,"image_url":"http://img01.liwushuo.com/image/161026/dxhiii89e.jpg-w720","order":758,"status":0,"target_id":1046250,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1046250","type":"post","webp_url":"http://img01.liwushuo.com/image/161026/dxhiii89e.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":730,"image_url":"http://img03.liwushuo.com/image/160929/68bib1c1a.jpg-w720","order":756,"status":0,"target_id":null,"target_url":"liwushuo:///page?type=dailylucky","type":"url","webp_url":"http://img03.liwushuo.com/image/160929/68bib1c1a.jpg?imageView2/2/w/720/q/85/format/webp"}]}
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
         * ad_monitors : []
         * channel : all
         * id : 760
         * image_url : http://img03.liwushuo.com/image/161028/bm7f1orxy.jpg-w720
         * order : 804
         * status : 0
         * target_id : 1046281
         * target_type : url
         * target_url : liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1046281
         * type : post
         * webp_url : http://img03.liwushuo.com/image/161028/bm7f1orxy.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            private int target_id;
            private String target_type;
            private String target_url;
            private String type;
            private String webp_url;
            private List<?> ad_monitors;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }
        }
    }
}
