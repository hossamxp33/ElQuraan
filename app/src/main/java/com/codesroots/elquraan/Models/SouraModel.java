package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali on 3/28/2018.
 */

public class SouraModel {


    /**
     * success : true
     * data : [{"id":2,"name":"الفَاتِحَة","tafseerlink":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","soundtrack":"http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3","sora_type":1,"ayat_counter":0,"part_id":4,"pages_counter":0},{"id":3,"name":"البَقَرَة ","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":286,"part_id":4,"pages_counter":20},{"id":4,"name":"آل عِمرَان","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":5,"name":"النِّسَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":6,"name":"المَائدة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":7,"name":"الأنعَام","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":8,"name":"الأعرَاف","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":9,"name":"الأنفَال\t ","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":10,"name":"التوبَة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":11,"name":"يُونس","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":12,"name":"هُود\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":13,"name":"يُوسُف","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":14,"name":"الرَّعْد","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":15,"name":"إبراهِيم","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":16,"name":"الحِجْر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":17,"name":"النَّحْل\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":18,"name":"الإسْرَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":19,"name":"الكهْف","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":20,"name":"مَريَم","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":21,"name":"طه","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":22,"name":"الأنبيَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":23,"name":"الحَج","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":24,"name":"المُؤمنون","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":25,"name":"النُّور","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":26,"name":"الفُرْقان","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":27,"name":"الشُّعَرَاء","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":28,"name":"النَّمْل","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":29,"name":"القَصَص\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":30,"name":"العَنكبوت","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":31,"name":"الرُّوم","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":32,"name":"لقمَان\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":33,"name":"السَّجدَة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":34,"name":"الأحزَاب","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":35,"name":"سَبَأ","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":36,"name":"فَاطِر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":37,"name":"يس","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":38,"name":"الصَّافات\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":39,"name":"ص","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":40,"name":"الزُّمَر\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":41,"name":"غَافِر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":42,"name":"فُصِّلَتْ","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":43,"name":"الشُّورَى\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":44,"name":"الزُّخْرُف","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":45,"name":"الدخَان ","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":46,"name":"الجَاثيَة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":47,"name":"الأحْقاف\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":48,"name":"محَمَّد","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":49,"name":"الفَتْح","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":50,"name":"الحُجرَات","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":51,"name":"ق","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":52,"name":"الذَّاريَات","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":53,"name":"الطُّور","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":54,"name":"النَّجْم\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":55,"name":"القَمَر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":56,"name":"الرَّحمن","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":57,"name":"الوَاقِعَة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":58,"name":"الحَديد","tafseerlink":"00","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":59,"name":"المجَادلة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":60,"name":"الحَشر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":61,"name":"المُمتَحنَة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":62,"name":"الصَّف","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":63,"name":"الجُمُعَة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":64,"name":"المنَافِقون","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":65,"name":"التغَابُن\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":66,"name":"الطلَاق","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":67,"name":"التحْريم","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":68,"name":"المُلْك","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":69,"name":"القَلَم","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":70,"name":"الحَاقَّة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":71,"name":"المعَارج","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":72,"name":"نُوح","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":73,"name":"الجِن","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":74,"name":"المُزَّمِّل","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":75,"name":"المُدَّثِّر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":76,"name":"القِيَامَة","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":77,"name":"الإنسَان","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":78,"name":"المُرسَلات","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":79,"name":"النَّبَأ\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":80,"name":"النّازعَات","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":81,"name":"عَبَس","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":82,"name":"التَّكوير\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":83,"name":"الانفِطار","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":84,"name":"المطفِّفِين\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":85,"name":"الانْشِقَاق","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":86,"name":"البرُوج","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":87,"name":"الطَّارِق\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":88,"name":"الأَعْلى","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":89,"name":"الغَاشِية","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":90,"name":"الفَجْر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":91,"name":"البَلَد","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":92,"name":"الشَّمْس\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":93,"name":"الليْل","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":94,"name":"الضُّحَى","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":95,"name":"الشَّرْح\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":96,"name":"التِّين","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":97,"name":"العَلَق","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":98,"name":"القَدْر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":99,"name":"البَينَة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":100,"name":"الزلزَلة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":101,"name":"العَادِيات","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":102,"name":"القَارِعة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":103,"name":"التَّكَاثر\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":104,"name":"العَصْر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":105,"name":"الهُمَزَة\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":106,"name":"الفِيل","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":107,"name":"قُرَيْش","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":108,"name":"المَاعُون","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":109,"name":"الكَوْثَر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":110,"name":"الكَافِرُون\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":111,"name":"النَّصر","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":112,"name":"المَسَد","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":113,"name":"الإخْلَاص\t","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":114,"name":"الفَلَق","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0},{"id":115,"name":"النَّاس","tafseerlink":"0","soundtrack":"0","sora_type":0,"ayat_counter":0,"part_id":0,"pages_counter":0}]
     */

    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
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
        /**
         * id : 2
         * name : الفَاتِحَة
         * tafseerlink : http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3
         * soundtrack : http://ia800309.us.archive.org/24/items/xboxgamer-538/001.mp3
         * sora_type : 1
         * ayat_counter : 0
         * part_id : 4
         * pages_counter : 0
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
    }
}
