package com.codesroots.elquraan.Models;

import java.util.List;

public class QuranModel {


    private List<QuraanBean> quraan;

    public List<QuraanBean> getQuraan() {
        return quraan;
    }

    public void setQuraan(List<QuraanBean> quraan) {
        this.quraan = quraan;
    }

    public static class QuraanBean {
        /**
         * id : 33
         * page_number : 1
         * page_image : 15225002232060371387.png
         * tafaseer_id : 2
         * part_id : 1
         * quraan_page : 1
         * tafaseer : {"id":2,"name":"الفَاتِحَة","tafseerlink":"http://quraan.codesroots.com/library/tafseermp/tevsirarabe/1.mp3","soundtrack":"http://quraan.codesroots.com/library/tafseermp/tilawahosari/001L.mp3","sora_type":2,"ayat_counter":7,"part_id":0,"pages_counter":1,"second_lang":"http://quraan.codesroots.com/library/tafseermp/tevsirwolof/001 - Fatiha.mp3","firstpage":1}
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
             * id : 2
             * name : الفَاتِحَة
             * tafseerlink : http://quraan.codesroots.com/library/tafseermp/tevsirarabe/1.mp3
             * soundtrack : http://quraan.codesroots.com/library/tafseermp/tilawahosari/001L.mp3
             * sora_type : 2
             * ayat_counter : 7
             * part_id : 0
             * pages_counter : 1
             * second_lang : http://quraan.codesroots.com/library/tafseermp/tevsirwolof/001 - Fatiha.mp3
             * firstpage : 1
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
