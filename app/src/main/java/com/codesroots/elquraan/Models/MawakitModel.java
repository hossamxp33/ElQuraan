package com.codesroots.elquraan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ali on 4/2/2018.
 */

public class MawakitModel {

    /**
     * title : Giza, Al Omraneyah, Giza, Egypt
     * query : Giza
     * for : daily
     * method : 1
     * prayer_method_name : Egyptian General Authority of Survey
     * daylight : 0
     * timezone : 2
     * map_image : http://maps.google.com/maps/api/staticmap?center=30.013056,31.208853&sensor=false&zoom=13&size=300x300
     * sealevel : 26
     * today_weather : {"pressure":1015,"temperature":"20"}
     * link : http://muslimsalat.com/Giza
     * qibla_direction : 136.1
     * latitude : 30.013056
     * longitude : 31.208853
     * address : Giza, Al Omraneyah, Giza, Egypt
     * city : Giza
     * state : Giza
     * postal_code :
     * country : Egypt
     * country_code : EG
     * items : [{"date_for":"2018-4-3","fajr":"4:11 am","shurooq":"5:38 am","dhuhr":"11:58 am","asr":"3:30 pm","maghrib":"6:19 pm","isha":"7:35 pm"}]
     * status_valid : 1
     * status_code : 1
     * status_description : Success.
     */

    @SerializedName("title")
    private String title;
    @SerializedName("query")
    private String query;
    @SerializedName("for")
    private String forX;
    @SerializedName("method")
    private int method;
    @SerializedName("prayer_method_name")
    private String prayerMethodName;
    @SerializedName("daylight")
    private String daylight;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("map_image")
    private String mapImage;
    @SerializedName("sealevel")
    private String sealevel;
    @SerializedName("today_weather")
    private TodayWeatherBean todayWeather;
    @SerializedName("link")
    private String link;
    @SerializedName("qibla_direction")
    private String qiblaDirection;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("postal_code")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("status_valid")
    private int statusValid;
    @SerializedName("status_code")
    private int statusCode;
    @SerializedName("status_description")
    private String statusDescription;
    @SerializedName("items")
    private List<ItemsBean> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getForX() {
        return forX;
    }

    public void setForX(String forX) {
        this.forX = forX;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getPrayerMethodName() {
        return prayerMethodName;
    }

    public void setPrayerMethodName(String prayerMethodName) {
        this.prayerMethodName = prayerMethodName;
    }

    public String getDaylight() {
        return daylight;
    }

    public void setDaylight(String daylight) {
        this.daylight = daylight;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

    public String getSealevel() {
        return sealevel;
    }

    public void setSealevel(String sealevel) {
        this.sealevel = sealevel;
    }

    public TodayWeatherBean getTodayWeather() {
        return todayWeather;
    }

    public void setTodayWeather(TodayWeatherBean todayWeather) {
        this.todayWeather = todayWeather;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQiblaDirection() {
        return qiblaDirection;
    }

    public void setQiblaDirection(String qiblaDirection) {
        this.qiblaDirection = qiblaDirection;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getStatusValid() {
        return statusValid;
    }

    public void setStatusValid(int statusValid) {
        this.statusValid = statusValid;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class TodayWeatherBean {
        /**
         * pressure : 1015
         * temperature : 20
         */

        @SerializedName("pressure")
        private int pressure;
        @SerializedName("temperature")
        private String temperature;

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }

    public static class ItemsBean {
        /**
         * date_for : 2018-4-3
         * fajr : 4:11 am
         * shurooq : 5:38 am
         * dhuhr : 11:58 am
         * asr : 3:30 pm
         * maghrib : 6:19 pm
         * isha : 7:35 pm
         */

        @SerializedName("date_for")
        private String dateFor;
        @SerializedName("fajr")
        private String fajr;
        @SerializedName("shurooq")
        private String shurooq;
        @SerializedName("dhuhr")
        private String dhuhr;
        @SerializedName("asr")
        private String asr;
        @SerializedName("maghrib")
        private String maghrib;
        @SerializedName("isha")
        private String isha;

        public String getDateFor() {
            return dateFor;
        }

        public void setDateFor(String dateFor) {
            this.dateFor = dateFor;
        }

        public String getFajr() {
            return fajr;
        }

        public void setFajr(String fajr) {
            this.fajr = fajr;
        }

        public String getShurooq() {
            return shurooq;
        }

        public void setShurooq(String shurooq) {
            this.shurooq = shurooq;
        }

        public String getDhuhr() {
            return dhuhr;
        }

        public void setDhuhr(String dhuhr) {
            this.dhuhr = dhuhr;
        }

        public String getAsr() {
            return asr;
        }

        public void setAsr(String asr) {
            this.asr = asr;
        }

        public String getMaghrib() {
            return maghrib;
        }

        public void setMaghrib(String maghrib) {
            this.maghrib = maghrib;
        }

        public String getIsha() {
            return isha;
        }

        public void setIsha(String isha) {
            this.isha = isha;
        }
    }
}
