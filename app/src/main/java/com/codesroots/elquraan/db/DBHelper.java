package com.codesroots.elquraan.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
   private static final String DB_NAME = "quraan_codesroots";
   private static final int DB_VERSION = 3;
   public DBHelper(Context context) {
       super(context, DB_NAME, null, DB_VERSION);
    }

   @Override
   public void onCreate(SQLiteDatabase db) {
       try {
           db.execSQL(Constants.CreateSourImagesData());
           db.execSQL(Constants.CreateSourNames());
            db.execSQL(Constants.CreateTimesTable());
           db.execSQL(Constants.CreateFavouriteTable());
           db.execSQL(Constants.CreateSourData());
           db.execSQL(Constants.CreatesewaInfoTable());
           db.execSQL(Constants.CreatesewaImagesTable());
       }catch (SQLException e){
           e.printStackTrace();
       }
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + Constants.Soura_TAble);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.SourDetailsTable);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.TB_NAME);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.FAV_NAME);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.SourNAmesTable);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.SourImages);
       db.execSQL("DROP TABLE IF EXISTS " + Constants.SourInfoTable);
       onCreate(db);
   }
}
