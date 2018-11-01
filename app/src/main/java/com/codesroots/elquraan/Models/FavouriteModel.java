package com.codesroots.elquraan.Models;

/**
 * Created by Ali on 4/29/2018.
 */

public class FavouriteModel {

    private int id,tartib,ayatcount,ids,databaseid;
    private String telawoa,tafseer,name;


    public int getDatabaseid() {
        return databaseid;
    }

    public void setDatabaseid(int databaseid) {
        this.databaseid = databaseid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTartib() {
        return tartib;
    }

    public void setTartib(int tartib) {
        this.tartib = tartib;
    }

    public int getAyatcount() {
        return ayatcount;
    }

    public void setAyatcount(int ayatcount) {
        this.ayatcount = ayatcount;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getTelawoa() {
        return telawoa;
    }

    public void setTelawoa(String telawoa) {
        this.telawoa = telawoa;
    }

    public String getTafseer() {
        return tafseer;
    }

    public void setTafseer(String tafseer) {
        this.tafseer = tafseer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
