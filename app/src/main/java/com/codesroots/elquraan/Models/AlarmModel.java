package com.codesroots.elquraan.Models;

/**
 * Created by Ali on 4/21/2018.
 */

public class AlarmModel {
    private int id,alarmid;
    private String text;
    private String time;
    private String date;

    public int getAlarmid() {
        return alarmid;
    }

    public void setAlarmid(int alarmid) {
        this.alarmid = alarmid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
