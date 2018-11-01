package com.codesroots.elquraan.Models;

import java.util.ArrayList;

/**
 * Created by Ali on 3/29/2018.
 */

public class SewarModel {

    /**
     * success : true
     * data : [{"id":80,"page_number":1,"page_image":"15225019731944756638.png","tafaseer_id":4,"part_id":3,"quraan_page":50,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":81,"page_number":2,"page_image":"15225022061579636059.png","tafaseer_id":4,"part_id":3,"quraan_page":51,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":82,"page_number":3,"page_image":"15225022361449876735.png","tafaseer_id":4,"part_id":3,"quraan_page":52,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":83,"page_number":4,"page_image":"15225022461597783360.png","tafaseer_id":4,"part_id":3,"quraan_page":53,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":85,"page_number":5,"page_image":"15225023281367222407.png","tafaseer_id":4,"part_id":3,"quraan_page":54,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":86,"page_number":6,"page_image":"1522502339641751105.png","tafaseer_id":4,"part_id":3,"quraan_page":55,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":87,"page_number":7,"page_image":"15225023571778482856.png","tafaseer_id":4,"part_id":3,"quraan_page":56,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":88,"page_number":8,"page_image":"15225023701560803507.png","tafaseer_id":4,"part_id":3,"quraan_page":57,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":89,"page_number":9,"page_image":"1522502393557510562.png","tafaseer_id":4,"part_id":3,"quraan_page":58,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":90,"page_number":10,"page_image":"15225024151075247267.png","tafaseer_id":4,"part_id":3,"quraan_page":59,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":91,"page_number":11,"page_image":"152250244558052912.png","tafaseer_id":4,"part_id":3,"quraan_page":60,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":92,"page_number":12,"page_image":"1522502457122220012.png","tafaseer_id":4,"part_id":3,"quraan_page":61,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":93,"page_number":13,"page_image":"15225024752102396595.png","tafaseer_id":4,"part_id":4,"quraan_page":62,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":94,"page_number":14,"page_image":"1522502493872599706.png","tafaseer_id":4,"part_id":4,"quraan_page":63,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":95,"page_number":15,"page_image":"15225025111902608298.png","tafaseer_id":4,"part_id":4,"quraan_page":64,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":96,"page_number":16,"page_image":"15225025381704298494.png","tafaseer_id":4,"part_id":4,"quraan_page":65,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":97,"page_number":17,"page_image":"15225026031723008742.png","tafaseer_id":4,"part_id":4,"quraan_page":66,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":98,"page_number":18,"page_image":"15225026241717883071.png","tafaseer_id":4,"part_id":4,"quraan_page":67,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":99,"page_number":19,"page_image":"1522502636261713214.png","tafaseer_id":4,"part_id":4,"quraan_page":68,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":100,"page_number":20,"page_image":"15225026491567373992.png","tafaseer_id":4,"part_id":4,"quraan_page":69,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":101,"page_number":21,"page_image":"15225026621094369604.png","tafaseer_id":4,"part_id":4,"quraan_page":70,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":102,"page_number":22,"page_image":"15225026791081428598.png","tafaseer_id":4,"part_id":4,"quraan_page":71,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":103,"page_number":23,"page_image":"1522502695533602619.png","tafaseer_id":4,"part_id":4,"quraan_page":72,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":104,"page_number":24,"page_image":"15225027081532844228.png","tafaseer_id":4,"part_id":4,"quraan_page":73,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":105,"page_number":25,"page_image":"1522502722590975253.png","tafaseer_id":4,"part_id":4,"quraan_page":74,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":106,"page_number":26,"page_image":"1522502735984267054.png","tafaseer_id":4,"part_id":4,"quraan_page":75,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}},{"id":107,"page_number":27,"page_image":"15225027492118623601.png","tafaseer_id":4,"part_id":4,"quraan_page":76,"tafaseer":{"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}}]
     */

    private boolean success;
    private ArrayList<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 80
         * page_number : 1
         * page_image : 15225019731944756638.png
         * tafaseer_id : 4
         * part_id : 3
         * quraan_page : 50
         * tafaseer : {"id":4,"name":"آل عِمرَان","tafseerlink":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","soundtrack":"https://mp3.askquran.com/audio/surah/efasy/002.mp3","sora_type":1,"ayat_counter":200,"part_id":0,"pages_counter":27,"second_lang":"https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3","firstpage":40}
         */

        private int id;
        private int page_number;
        private String page_image;
        private int tafaseer_id;
        private int part_id;
        private int quraan_page;
        private TafaseerBean tafaseer;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPage_number() {
            return page_number;
        }

        public void setPage_number(int page_number) {
            this.page_number = page_number;
        }

        public String getPage_image() {
            return page_image;
        }

        public void setPage_image(String page_image) {
            this.page_image = page_image;
        }

        public int getTafaseer_id() {
            return tafaseer_id;
        }

        public void setTafaseer_id(int tafaseer_id) {
            this.tafaseer_id = tafaseer_id;
        }

        public int getPart_id() {
            return part_id;
        }

        public void setPart_id(int part_id) {
            this.part_id = part_id;
        }

        public int getQuraan_page() {
            return quraan_page;
        }

        public void setQuraan_page(int quraan_page) {
            this.quraan_page = quraan_page;
        }

        public TafaseerBean getTafaseer() {
            return tafaseer;
        }

        public void setTafaseer(TafaseerBean tafaseer) {
            this.tafaseer = tafaseer;
        }

        public static class TafaseerBean {
            /**
             * id : 4
             * name : آل عِمرَان
             * tafseerlink : https://mp3.askquran.com/audio/surah/efasy/002.mp3
             * soundtrack : https://mp3.askquran.com/audio/surah/efasy/002.mp3
             * sora_type : 1
             * ayat_counter : 200
             * part_id : 0
             * pages_counter : 27
             * second_lang : https://ia600403.us.archive.org/5/items/Sama3almelouk_yahoo_20160525/%D8%A8%D8%A8%D8%A7%D8%A8%D9%83.mp3
             * firstpage : 40
             */

            private int id;
            private String name;
            private String tafseerlink;
            private String soundtrack;
            private int sora_type;
            private int ayat_counter;
            private int part_id;
            private int pages_counter;
            private String second_lang;
            private int firstpage;

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

            public int getSora_type() {
                return sora_type;
            }

            public void setSora_type(int sora_type) {
                this.sora_type = sora_type;
            }

            public int getAyat_counter() {
                return ayat_counter;
            }

            public void setAyat_counter(int ayat_counter) {
                this.ayat_counter = ayat_counter;
            }

            public int getPart_id() {
                return part_id;
            }

            public void setPart_id(int part_id) {
                this.part_id = part_id;
            }

            public int getPages_counter() {
                return pages_counter;
            }

            public void setPages_counter(int pages_counter) {
                this.pages_counter = pages_counter;
            }

            public String getSecond_lang() {
                return second_lang;
            }

            public void setSecond_lang(String second_lang) {
                this.second_lang = second_lang;
            }

            public int getFirstpage() {
                return firstpage;
            }

            public void setFirstpage(int firstpage) {
                this.firstpage = firstpage;
            }
        }
    }
}
