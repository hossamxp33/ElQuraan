package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali on 4/24/2018.
 */

public class FullQuranModel {


    @SerializedName("quraan")
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
         * tafaseer : {"id":2,"name":"الفَاتِحَة","tafseerlink":"http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3","soundtrack":"http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3","sora_type":1,"ayat_counter":7,"part_id":0,"pages_counter":1,"second_lang":"http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3","firstpage":1}
         */

        @SerializedName("id")
        private int id;
        @SerializedName("page_number")
        private int pageNumber;
        @SerializedName("page_image")
        private String pageImage;
        @SerializedName("tafaseer_id")
        private int tafaseerId;
        @SerializedName("part_id")
        private int partId;
        @SerializedName("quraan_page")
        private int quraanPage;
        @SerializedName("tafaseer")
        private TafaseerBean tafaseer;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public String getPageImage() {
            return pageImage;
        }

        public void setPageImage(String pageImage) {
            this.pageImage = pageImage;
        }

        public int getTafaseerId() {
            return tafaseerId;
        }

        public void setTafaseerId(int tafaseerId) {
            this.tafaseerId = tafaseerId;
        }

        public int getPartId() {
            return partId;
        }

        public void setPartId(int partId) {
            this.partId = partId;
        }

        public int getQuraanPage() {
            return quraanPage;
        }

        public void setQuraanPage(int quraanPage) {
            this.quraanPage = quraanPage;
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
             * tafseerlink : http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3
             * soundtrack : http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3
             * sora_type : 1
             * ayat_counter : 7
             * part_id : 0
             * pages_counter : 1
             * second_lang : http://ia801409.us.archive.org/25/items/Mohammed_Sidik_Almanchawi/002.mp3
             * firstpage : 1
             */

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
            @SerializedName("second_lang")
            private String secondLang;
            @SerializedName("firstpage")
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

            public String getSecondLang() {
                return secondLang;
            }

            public void setSecondLang(String secondLang) {
                this.secondLang = secondLang;
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
