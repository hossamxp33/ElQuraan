package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ali on 4/25/2018.
 */

public class All_Sour_Model {


    @SerializedName("data")
    private ArrayList<DataBean> data;

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * name : الفَاتِحَة
         * tafseerlink : https://drive.google.com/file/d/1Z7UBwTrv1inK5Bu3fURsfMdAnoMEpkV9/view?usp=sharing
         * soundtrack : https://drive.google.com/file/d/1XQZm1HLVm6X9j7QrFztyZxXpkSbUtt9K/view?usp=sharing
         * sora_type : 1
         * ayat_counter : 7
         * part_id : 0
         * pages_counter : 1
         * quraan : [{"tafaseer_id":2,"TotalPages":1}]
         */
        private boolean isOpened = false ;
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("second_lang")
        private String second_lang;
        @SerializedName("tafseerlink")
        private String tafseerlink;
        @SerializedName("firstpage")
        private int firstpage;
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
        private ArrayList<QuraanBean> quraan;

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

        public boolean isOpened() {
            return isOpened;
        }

        public void setOpened(boolean opened) {
            isOpened = opened;
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

        public ArrayList<QuraanBean> getQuraan() {
            return quraan;
        }

        public void setQuraan(ArrayList<QuraanBean> quraan) {
            this.quraan = quraan;
        }

        public static class QuraanBean {
            /**
             * tafaseer_id : 2
             * TotalPages : 1
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
