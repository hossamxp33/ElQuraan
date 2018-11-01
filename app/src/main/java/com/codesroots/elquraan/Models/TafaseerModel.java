package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ali on 4/19/2018.
 */

public class TafaseerModel {


    /**
     * success : true
     * othertafaseer : [{"id":1,"title":"3","link":"link","created":"2018-04-19T12:08:09+0000","modified":"2018-04-19T12:08:09+0000"},{"id":2,"title":"4","link":"link","created":"2018-04-19T12:08:16+0000","modified":"2018-04-19T12:08:16+0000"},{"id":3,"title":"تفسير جديد","link":"http://quraan.codesroots.com/library/quraan/mabroook.MP4","created":"2018-04-21T11:26:19+0000","modified":"2018-04-21T11:26:19+0000"},{"id":4,"title":"تفسير آخر","link":"http://quraan.codesroots.com/library/quraan/mabroook.MP4","created":"2018-04-21T11:35:34+0000","modified":"2018-04-21T11:35:34+0000"}]
     */

    @SerializedName("success")
    private boolean success;
    @SerializedName("othertafaseer")
    private ArrayList<OthertafaseerBean> othertafaseer;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<OthertafaseerBean> getOthertafaseer() {
        return othertafaseer;
    }

    public void setOthertafaseer(ArrayList<OthertafaseerBean> othertafaseer) {
        this.othertafaseer = othertafaseer;
    }

    public static class OthertafaseerBean {
        /**
         * id : 1
         * title : 3
         * link : link
         * created : 2018-04-19T12:08:09+0000
         * modified : 2018-04-19T12:08:09+0000
         */
        private boolean isPlaying = false;

        public boolean isPlaying() {
            return isPlaying;
        }

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("link")
        private String link;
        @SerializedName("created")
        private String created;
        @SerializedName("modified")
        private String modified;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }
    }
}
