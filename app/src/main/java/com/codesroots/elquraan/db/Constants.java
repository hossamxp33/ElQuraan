package com.codesroots.elquraan.db;

import android.media.Image;

/**
 * Created by ali on 9/30/2016.
 */
public class Constants {

    public static final String ROW_ID = "id";
    public static final String SourNAmesTable = "SourNAmesTable";
    public static final String SourDetailsTable = "quran_images";
    public static final String SourInfoTable = "quran_sewardata";
    public static final String SourImages = "quran_sewarimages";

     public  static final int DB_VERSION = 2;
    public static final String Soura_TAble = "quran_list";
    public static final String SouraId = "soura_id";
    public static final String SouraName = "soura_name";
    public static final String SouraNumber = "soura_number";
    public static final String Soura_gozaa = "soura_gozaa";
    public static final String Soura_IMage = "soura_image";
    public static final String ImageID = "image_id";
    public static final String SouraTelawoa = "soura_telawoa";
    public static final String SouraTafseer = "soura_tafseer";
    public static final String Pagescount = "pages_count";
    public static final String AYAT_COUNTER = "ayat_counter";
    public static final String FROM = "froms";
    public static final String TO = "tos";
    public static final String TYPE = "types";
    public static final String Title = "titel";
    public static final String time = "timesss";
    public static final String date = "datessa";
    public static final String TB_NAME = "alarms";
    public static final String ids = "ids";
    public static final String FAV_NAME = "favouritetable";
    public static final String urdolang = "urdolang";
    public static final String page = "pageesa";
    public static final String Imag = "soraImage";
    public static final String PartId = "partId";
    public static final String Quranpage = "quran_page";
    public static final String FirstPAge = "first_page";
    public static final String ImagId = "ImagId";
    public static final String SoundTrackPath = "SoundTrackPath";
    public static final String TafserPath = "TafserPath";
    public static final String SecondLanguage = "SecondLanguage";
    public static final String Sora_name = "Soraname";
    public static final String PAGES_TABLE = "PAGES_TABLE";



    public static String CreateSourNames() {
        return "CREATE TABLE IF NOT EXISTS " + Soura_TAble + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SouraName + " TEXT, "  +    SouraId + " INTEGER, " +    SouraTelawoa + " TEXT, "
                +    SouraTafseer + " TEXT, "+    AYAT_COUNTER + " INTEGER, " +    FROM + " INTEGER, "
                +    TO + " INTEGER, "+    FirstPAge + " INTEGER, " +   SouraNumber + " TEXT, " +   urdolang + " TEXT, "
                +  TYPE + " INTEGER, " +  Pagescount + " TEXT, " +
                Soura_gozaa + " TEXT)";
    }

    public static String CreateSourData() {
        return "CREATE TABLE IF NOT EXISTS " + SourNAmesTable + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ids + " INTEGER, "  +    SouraId + " INTEGER, " +    ImageID + " INTEGER, "+    Soura_IMage + " TEXT, "
                +   SouraNumber + " TEXT, "  + SouraTelawoa + " TEXT, " + SouraName + " TEXT, "  + SouraTafseer + " TEXT, "  +
                Soura_gozaa + " INTEGER)";
    }

    public static String CreateSourImagesData() {

        return "CREATE TABLE IF NOT EXISTS " + SourDetailsTable + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ids + " INTEGER, "  +    SouraId + " INTEGER, " +    ImageID + " INTEGER, "+    Soura_IMage + " BLOB, "
                +   SouraNumber + " TEXT, "  + SouraTelawoa + " TEXT, "  + urdolang + " TEXT, "   +  page + " INTEGER, "
                + SouraName + " TEXT, "  + SouraTafseer + " TEXT, "  +
                Soura_gozaa + " INTEGER)";
    }

    public static String CreateTimesTable() {
        return "CREATE TABLE IF NOT EXISTS " + TB_NAME + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Title + " TEXT, "  +   time + " TEXT, "
                +  date + " TEXT NOT NULL)";
    }
    public static String CreateFavouriteTable() {
        return "CREATE TABLE IF NOT EXISTS " + FAV_NAME + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ids + " INTEGER, "  +    SouraId + " INTEGER, "+    AYAT_COUNTER + " INTEGER, "
                + SouraNumber + " TEXT, "  +  Pagescount + " TEXT, " +
                SouraTelawoa + " TEXT, " + SouraName + " TEXT, "  + SouraTafseer + " TEXT)";
    }

    public static String CreatesewaInfoTable() {

        return "CREATE TABLE IF NOT EXISTS " + SourInfoTable + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SouraId + " INTEGER, "
                + ImageID + " INTEGER, "
                + Imag + " TEXT, "  +
                PartId + " INTEGER, " + Quranpage + " INTEGER ," +
                SoundTrackPath + " TEXT, "  +
                 TafserPath + " TEXT, "  +
                 SecondLanguage +   " TEXT, "+
                Sora_name + " TEXT ,"+
                AYAT_COUNTER + " INTEGER )";
    }


    public static String CreatePagesTable() {
        return "CREATE TABLE IF NOT EXISTS " + PAGES_TABLE + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SouraName + " TEXT, "+
                AYAT_COUNTER + " INTEGER, "+
                urdolang + " TEXT,"+
                TYPE + " INTEGER, " +  Pagescount + " TEXT, " +
                Soura_gozaa + " TEXT)";
    }



    public static String CreatesewaImagesTable() {

        return "CREATE TABLE IF NOT EXISTS " + SourImages + " (" +"id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SouraId + " INTEGER, "
                +ImagId + " INTEGER, "
                + Imag + " TEXT )";
    }

}
