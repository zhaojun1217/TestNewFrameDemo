package test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 16/10/27.
 */
public class HomeTitleBean implements Serializable{

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

    public static class DataBean  implements Serializable{
        /**
         * editable : true
         * id : 10
         * name : 送女票
         * url :
         */

        private List<CandidatesBean> candidates;
        /**
         * editable : false
         * id : 100
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

    /**
     * Created by dllo on 16/10/25.
     */
    public static class HotsaleSameBean implements Serializable {


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

        public static class DataBean implements Serializable {
            private String cover_image;
            private String cover_url;
            private String cover_webp;


            private PagingBean paging;
            private String share_url;

            private List<ItemsBean> items;

            public String getCover_image() {
                return cover_image;
            }

            public void setCover_image(String cover_image) {
                this.cover_image = cover_image;
            }

            public String getCover_url() {
                return cover_url;
            }

            public void setCover_url(String cover_url) {
                this.cover_url = cover_url;
            }

            public String getCover_webp() {
                return cover_webp;
            }

            public void setCover_webp(String cover_webp) {
                this.cover_webp = cover_webp;
            }

            public PagingBean getPaging() {
                return paging;
            }

            public void setPaging(PagingBean paging) {
                this.paging = paging;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class PagingBean {
                private String next_url;

                public String getNext_url() {
                    return next_url;
                }

                public void setNext_url(String next_url) {
                    this.next_url = next_url;
                }
            }

            public static class ItemsBean implements Serializable {
                private Object ad_monitors;
                private Object brand_id;
                private Object brand_order;
                private int category_id;
                private String cover_image_url;
                private String cover_webp_url;
                private int created_at;
                private String description;
                private int editor_id;
                private int favorites_count;
                private int id;
                private String keywords;
                private String name;
                private int order;
                private String price;
                private String purchase_id;
                private Object purchase_shop_id;
                private int purchase_status;
                private int purchase_type;
                private String purchase_url;
                private String short_description;
                private int subcategory_id;
                private int updated_at;
                private String url;
                private List<String> image_urls;
                private List<?> post_ids;

                public Object getAd_monitors() {
                    return ad_monitors;
                }

                public void setAd_monitors(Object ad_monitors) {
                    this.ad_monitors = ad_monitors;
                }

                public Object getBrand_id() {
                    return brand_id;
                }

                public void setBrand_id(Object brand_id) {
                    this.brand_id = brand_id;
                }

                public Object getBrand_order() {
                    return brand_order;
                }

                public void setBrand_order(Object brand_order) {
                    this.brand_order = brand_order;
                }

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
                }

                public String getCover_webp_url() {
                    return cover_webp_url;
                }

                public void setCover_webp_url(String cover_webp_url) {
                    this.cover_webp_url = cover_webp_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getEditor_id() {
                    return editor_id;
                }

                public void setEditor_id(int editor_id) {
                    this.editor_id = editor_id;
                }

                public int getFavorites_count() {
                    return favorites_count;
                }

                public void setFavorites_count(int favorites_count) {
                    this.favorites_count = favorites_count;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPurchase_id() {
                    return purchase_id;
                }

                public void setPurchase_id(String purchase_id) {
                    this.purchase_id = purchase_id;
                }

                public Object getPurchase_shop_id() {
                    return purchase_shop_id;
                }

                public void setPurchase_shop_id(Object purchase_shop_id) {
                    this.purchase_shop_id = purchase_shop_id;
                }

                public int getPurchase_status() {
                    return purchase_status;
                }

                public void setPurchase_status(int purchase_status) {
                    this.purchase_status = purchase_status;
                }

                public int getPurchase_type() {
                    return purchase_type;
                }

                public void setPurchase_type(int purchase_type) {
                    this.purchase_type = purchase_type;
                }

                public String getPurchase_url() {
                    return purchase_url;
                }

                public void setPurchase_url(String purchase_url) {
                    this.purchase_url = purchase_url;
                }

                public String getShort_description() {
                    return short_description;
                }

                public void setShort_description(String short_description) {
                    this.short_description = short_description;
                }

                public int getSubcategory_id() {
                    return subcategory_id;
                }

                public void setSubcategory_id(int subcategory_id) {
                    this.subcategory_id = subcategory_id;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<String> getImage_urls() {
                    return image_urls;
                }

                public void setImage_urls(List<String> image_urls) {
                    this.image_urls = image_urls;
                }

                public List<?> getPost_ids() {
                    return post_ids;
                }

                public void setPost_ids(List<?> post_ids) {
                    this.post_ids = post_ids;
                }
            }
        }
    }
}
