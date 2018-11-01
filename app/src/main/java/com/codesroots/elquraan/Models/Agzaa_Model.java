package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali on 4/8/2018.
 */

public class Agzaa_Model {


    /**
     * success : true
     * parts : [{"id":4,"name":"الجزء الأول ","from_page":1,"to_page":21,"mini_parts":[{"id":1,"part_id":4,"tafaseer_id":2,"tafaseer":{"id":2,"name":"الفَاتِحَة","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":1,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":2,"TotalPages":2}]}},{"id":2,"part_id":4,"tafaseer_id":3,"tafaseer":{"id":3,"name":"البَقَرَة ","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":0,"ayat_counter":286,"part_id":0,"pages_counter":20,"quraan":[{"tafaseer_id":3,"TotalPages":45}]}}]},{"id":5,"name":"الجزء الثاني ","from_page":22,"to_page":41,"mini_parts":[{"id":3,"part_id":5,"tafaseer_id":3,"tafaseer":{"id":3,"name":"البَقَرَة ","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":0,"ayat_counter":286,"part_id":0,"pages_counter":20,"quraan":[{"tafaseer_id":3,"TotalPages":45}]}}]},{"id":6,"name":"الجزء الثالث ","from_page":42,"to_page":61,"mini_parts":[{"id":4,"part_id":6,"tafaseer_id":3,"tafaseer":{"id":3,"name":"البَقَرَة ","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":0,"ayat_counter":286,"part_id":0,"pages_counter":20,"quraan":[{"tafaseer_id":3,"TotalPages":45}]}}]},{"id":7,"name":"الجزء  الرابع ","from_page":62,"to_page":81,"mini_parts":[{"id":5,"part_id":7,"tafaseer_id":4,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":4,"TotalPages":27}]}}]},{"id":8,"name":"الجزء الخامس ","from_page":82,"to_page":101,"mini_parts":[{"id":6,"part_id":8,"tafaseer_id":5,"tafaseer":{"id":5,"name":"النِّسَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":5,"TotalPages":30}]}}]},{"id":9,"name":"الجزء السادس ","from_page":102,"to_page":121,"mini_parts":[{"id":7,"part_id":9,"tafaseer_id":5,"tafaseer":{"id":5,"name":"النِّسَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":5,"TotalPages":30}]}},{"id":8,"part_id":9,"tafaseer_id":6,"tafaseer":{"id":6,"name":"المَائدة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":6,"TotalPages":29}]}}]},{"id":10,"name":"الجزء السابع ","from_page":121,"to_page":141,"mini_parts":[{"id":9,"part_id":10,"tafaseer_id":6,"tafaseer":{"id":6,"name":"المَائدة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":6,"TotalPages":29}]}},{"id":10,"part_id":10,"tafaseer_id":7,"tafaseer":{"id":7,"name":"الأنعَام","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":7,"TotalPages":24}]}}]},{"id":11,"name":"الجزء الثامن ","from_page":142,"to_page":161,"mini_parts":[]},{"id":12,"name":"الجزء التاسع ","from_page":162,"to_page":181,"mini_parts":[]},{"id":13,"name":"الجزء العاشر ","from_page":182,"to_page":201,"mini_parts":[]},{"id":14,"name":"الجزء الحادي عشر ","from_page":201,"to_page":221,"mini_parts":[]},{"id":15,"name":"الجزء الثاني عشر ","from_page":222,"to_page":241,"mini_parts":[]},{"id":16,"name":"الجزء الثالث عشر ","from_page":241,"to_page":261,"mini_parts":[]},{"id":17,"name":"الجزء الرابع عشر ","from_page":262,"to_page":281,"mini_parts":[]},{"id":18,"name":"الجزء الخامس عشر ","from_page":282,"to_page":301,"mini_parts":[]},{"id":19,"name":"الجزء السادس عشر ","from_page":302,"to_page":321,"mini_parts":[]},{"id":20,"name":"الجزء السابع عشر ","from_page":322,"to_page":341,"mini_parts":[]},{"id":21,"name":"الجزء الثامن عشر ","from_page":342,"to_page":361,"mini_parts":[]},{"id":22,"name":"الجزء التاسع عشر ","from_page":362,"to_page":381,"mini_parts":[]},{"id":23,"name":"الجزء العشرون ","from_page":382,"to_page":401,"mini_parts":[]}]
     */

    @SerializedName("success")
    private boolean success;
    @SerializedName("parts")
    private List<PartsBean> parts;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PartsBean> getParts() {
        return parts;
    }

    public void setParts(List<PartsBean> parts) {
        this.parts = parts;
    }

    public static class PartsBean {
        /**
         * id : 4
         * name : الجزء الأول
         * from_page : 1
         * to_page : 21
         * mini_parts : [{"id":1,"part_id":4,"tafaseer_id":2,"tafaseer":{"id":2,"name":"الفَاتِحَة","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":1,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":2,"TotalPages":2}]}},{"id":2,"part_id":4,"tafaseer_id":3,"tafaseer":{"id":3,"name":"البَقَرَة ","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":0,"ayat_counter":286,"part_id":0,"pages_counter":20,"quraan":[{"tafaseer_id":3,"TotalPages":45}]}}]
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("from_page")
        private int fromPage;
        @SerializedName("to_page")
        private int toPage;
        @SerializedName("mini_parts")
        private List<MiniPartsBean> miniParts;

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

        public int getFromPage() {
            return fromPage;
        }

        public void setFromPage(int fromPage) {
            this.fromPage = fromPage;
        }

        public int getToPage() {
            return toPage;
        }

        public void setToPage(int toPage) {
            this.toPage = toPage;
        }

        public List<MiniPartsBean> getMiniParts() {
            return miniParts;
        }

        public void setMiniParts(List<MiniPartsBean> miniParts) {
            this.miniParts = miniParts;
        }

        public static class MiniPartsBean {
            /**
             * id : 1
             * part_id : 4
             * tafaseer_id : 2
             * tafaseer : {"id":2,"name":"الفَاتِحَة","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":1,"ayat_counter":0,"part_id":0,"pages_counter":0,"quraan":[{"tafaseer_id":2,"TotalPages":2}]}
             */

            @SerializedName("id")
            private int id;
            @SerializedName("part_id")
            private int partId;
            @SerializedName("tafaseer_id")
            private int tafaseerId;
            @SerializedName("tafaseer")
            private TafaseerBean tafaseer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPartId() {
                return partId;
            }

            public void setPartId(int partId) {
                this.partId = partId;
            }

            public int getTafaseerId() {
                return tafaseerId;
            }

            public void setTafaseerId(int tafaseerId) {
                this.tafaseerId = tafaseerId;
            }

            public TafaseerBean getTafaseer() {
                return tafaseer;
            }

            public void setTafaseer(TafaseerBean tafaseer) {
                this.tafaseer = tafaseer;
            }

            public static class TafaseerBean {
                /**
                 * id : 2
                 * name : الفَاتِحَة
                 * tafseerlink : http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3
                 * soundtrack : http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3
                 * sora_type : 1
                 * ayat_counter : 0
                 * part_id : 0
                 * pages_counter : 0
                 * quraan : [{"tafaseer_id":2,"TotalPages":2}]
                 */
                private  int from,to;
                @SerializedName("id")
                private int id;
                @SerializedName("name")
                private String name;
                @SerializedName("tafseerlink")
                private String tafseerlink;
                @SerializedName("soundtrack")
                private String soundtrack;
                @SerializedName("sora_type")
                private int soraType;
                @SerializedName("ayat_counter")
                private int ayatCounter;
                @SerializedName("part_id")
                private int partId;
                @SerializedName("pages_counter")
                private int pagesCounter;
                @SerializedName("quraan")
                private List<QuraanBean> quraan;

                public int getFrom() {
                    return from;
                }

                public void setFrom(int from) {
                    this.from = from;
                }

                public int getTo() {
                    return to;
                }

                public void setTo(int to) {
                    this.to = to;
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

                public String getTafseerlink() {
                    return tafseerlink;
                }

                public void setTafseerlink(String tafseerlink) {
                    this.tafseerlink = tafseerlink;
                }

                public String getSoundtrack() {
                    return soundtrack;
                }

                public void setSoundtrack(String soundtrack) {
                    this.soundtrack = soundtrack;
                }

                public int getSoraType() {
                    return soraType;
                }

                public void setSoraType(int soraType) {
                    this.soraType = soraType;
                }

                public int getAyatCounter() {
                    return ayatCounter;
                }

                public void setAyatCounter(int ayatCounter) {
                    this.ayatCounter = ayatCounter;
                }

                public int getPartId() {
                    return partId;
                }

                public void setPartId(int partId) {
                    this.partId = partId;
                }

                public int getPagesCounter() {
                    return pagesCounter;
                }

                public void setPagesCounter(int pagesCounter) {
                    this.pagesCounter = pagesCounter;
                }

                public List<QuraanBean> getQuraan() {
                    return quraan;
                }

                public void setQuraan(List<QuraanBean> quraan) {
                    this.quraan = quraan;
                }

                public static class QuraanBean {
                    /**
                     * tafaseer_id : 2
                     * TotalPages : 2
                     */

                    @SerializedName("tafaseer_id")
                    private int tafaseerId;
                    @SerializedName("TotalPages")
                    private int TotalPages;

                    public int getTafaseerId() {
                        return tafaseerId;
                    }

                    public void setTafaseerId(int tafaseerId) {
                        this.tafaseerId = tafaseerId;
                    }

                    public int getTotalPages() {
                        return TotalPages;
                    }

                    public void setTotalPages(int TotalPages) {
                        this.TotalPages = TotalPages;
                    }
                }
            }
        }
    }
}
