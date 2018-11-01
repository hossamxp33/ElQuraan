package com.codesroots.elquraan.Models;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali on 3/29/2018.
 */

public class SewarModelView {



     private boolean success;
     private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

         private int id;
         private int pageNumber;
         private Bitmap pageImage;
         private int SoraId;
         private SoraBean sora;



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

        public Bitmap getPageImage() {
            return pageImage;
        }

        public void setPageImage(Bitmap pageImage) {
            this.pageImage = pageImage;
        }

        public int getSoraId() {
            return SoraId;
        }

        public void setSoraId(int SoraId) {
            this.SoraId = SoraId;
        }

        public SoraBean getSora() {
            return sora;
        }

        public void setSora(SoraBean sora) {
            this.sora = sora;
        }

        public static class SoraBean {
            /**
             * id : 1
             * name : ASD
             * tafseerlink : 2323
             * soundtrack : 2323
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("second_lang")
            private String second_lang;
            @SerializedName("tafseerlink")
            private String tafseerlink;
            @SerializedName("soundtrack")
            private String soundtrack;
            private int ids;
            public int getId() {
                return id;
            }
            public int getIds() {
                return ids;
            }

            public void setIds(int ids) {
                this.ids = ids;
            }
            public void setId(int id) {
                this.id = id;
            }

            public String getSecond_lang() {
                return second_lang;
            }

            public void setSecond_lang(String second_lang) {
                this.second_lang = second_lang;
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
        }
    }
}
