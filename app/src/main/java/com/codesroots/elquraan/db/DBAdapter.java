package com.codesroots.elquraan.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import static com.codesroots.elquraan.db.Constants.ImagId;
import static com.codesroots.elquraan.db.Constants.ImageID;
import static com.codesroots.elquraan.db.Constants.SourImages;
import static com.codesroots.elquraan.db.Constants.SourInfoTable;
import static com.codesroots.elquraan.db.Constants.SouraId;
import static com.codesroots.elquraan.db.Constants.ids;


public class DBAdapter {

	private Context context;
	private DBHelper DBhelper;
	private SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBhelper = new DBHelper(context);
	}

	public DBAdapter openDB() {
		try {
			db = DBhelper.getWritableDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DBAdapter open() throws SQLiteException {
		db = DBhelper.getWritableDatabase();
		return this;
	}

	public boolean isCreated() {
		if (db != null) {
			return db.isOpen();
		}

		return false;
	}

	public boolean isOpen() {
		return db.isOpen();
	}

	public void close() {
		try {
			DBhelper.close();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public long addSouraName(String name, int souraid,
                    int souranumber, int souragozaa,String telawoa,String tafseer,
							 int pagescount,int from,int to,int ayat_number,int type,String urdo,int FirstPage) {
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.SouraName, name);
			cv.put(SouraId,souraid);
			cv.put(Constants.SouraNumber,souranumber);
			cv.put(Constants.Soura_gozaa,souragozaa);
			cv.put(Constants.SouraTelawoa,telawoa);
			cv.put(Constants.SouraTafseer,tafseer);
			cv.put(Constants.Pagescount,pagescount);
			cv.put(Constants.FROM,from);
			cv.put(Constants.TO,to);
			cv.put(Constants.AYAT_COUNTER,ayat_number);
			cv.put(Constants.TYPE,type);
			cv.put(Constants.FirstPAge,FirstPage);
 			cv.put(Constants.urdolang,urdo);
			return db.insert(Constants.Soura_TAble, Constants.ROW_ID, cv);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



	public long addsouraimages(int souraid, int imageid,String imag) {

		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.SouraId, souraid);
			cv.put(Constants.ImagId,imageid);
			cv.put(Constants.Imag,imag);

			return db.insert(Constants.SourImages, Constants.ROW_ID, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long addSouraImage(int ids, int souraid,
							 int souranumber, int souragozaa,byte[] image,int imageid,
							  String telawoa,String tafseer,String souraname ,String urdolang,int page) {
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.ids, ids);
			cv.put(SouraId,souraid);
			cv.put(Constants.SouraName,souraname);
			cv.put(Constants.SouraNumber,souranumber);
			cv.put(Constants.Soura_gozaa,souragozaa);
			cv.put(Constants.Soura_IMage,image);
			cv.put(ImageID,imageid);
			cv.put(Constants.SouraTelawoa,telawoa);
			cv.put(Constants.urdolang,urdolang);
			cv.put(Constants.SouraTafseer,tafseer);
			cv.put(Constants.page,page);

			return db.insert(Constants.SourDetailsTable, Constants.ROW_ID, cv);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long addSouraData(int ids, int souraid,
							  int souranumber, int souragozaa,String image,int imageid,
							  String telawoa,String tafseer,String souraname,String urdotafseer) {
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.ids, ids);
			cv.put(SouraId,souraid);
			cv.put(Constants.SouraName,souraname);
			cv.put(Constants.SouraNumber,souranumber);
			cv.put(Constants.Soura_gozaa,souragozaa);
			cv.put(Constants.Soura_IMage,image);
			cv.put(ImageID,imageid);
			cv.put(Constants.SouraTelawoa,telawoa);
			cv.put(Constants.SouraTafseer,tafseer);
			cv.put(Constants.urdolang,urdotafseer);
			return db.insert(Constants.SourDetailsTable, Constants.ROW_ID, cv);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



	public long addSouraParts(int souraid, int imageid, String img, int partid,
							  int quranpage,String trackpath,String tafserpath,String secondlang,String soraname,int ayatcount) {

		try {
			ContentValues cv = new ContentValues();
			cv.put(SouraId,souraid);
			cv.put(ImageID,imageid);
			cv.put(Constants.Imag,img);
			cv.put(Constants.PartId,partid);
			cv.put(Constants.SoundTrackPath,trackpath);
			cv.put(Constants.TafserPath,tafserpath);
			cv.put(Constants.SecondLanguage,secondlang);
			cv.put(Constants.Sora_name,soraname);
			cv.put(Constants.AYAT_COUNTER,ayatcount);
			cv.put(Constants.Quranpage,quranpage);
		  Long x=db.insert(Constants.SourInfoTable,Constants.ROW_ID, cv);
			return x;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



	public boolean CheckIsSorainfoAleadyExists( int id) {

		db = DBhelper.getWritableDatabase();
	//	String Query  = "Select * from " + SourInfoTable + " where " + SouraId + " = " + id;
		String Query  = "Select * from " + SourInfoTable ;
		Cursor cursor = db.rawQuery(Query, null);
		cursor.moveToFirst();
		if(cursor.getCount() <= 0){
			cursor.close();
			return false;
		      }
		cursor.close();
		return true;
	}


	public long addFavourite(int ids, int souraid,
							  String telawoa,String tafseer,String souraname,int tartib,int counts) {
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.ids, ids);
			cv.put(SouraId,souraid);
			cv.put(Constants.SouraName,souraname);
 			cv.put(Constants.Pagescount,tartib);
			cv.put(Constants.AYAT_COUNTER,counts);
			cv.put(Constants.SouraTelawoa,telawoa);
			cv.put(Constants.SouraTafseer,tafseer);
			return db.insert(Constants.FAV_NAME, Constants.ROW_ID, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Cursor getSourNames() {
		String[] columns = {
				Constants.ROW_ID, Constants.SouraNumber,
				SouraId,Constants.SouraName,Constants.Soura_gozaa,
				Constants.SouraTelawoa,Constants.SouraTafseer,Constants.Pagescount
		,Constants.AYAT_COUNTER,Constants.FROM,Constants.TO,Constants.TYPE,Constants.urdolang,Constants.FirstPAge};
		return db.query(Constants.Soura_TAble, columns, null, null,
				null, null, null);
	}

	public Cursor getSourInfo (int id){

		//String Query = "Select * from " + SourInfoTable + " where " + SouraId + " = " + id;
		String Query = "Select * from " + SourInfoTable ;
		Cursor cursor = db.rawQuery(Query, null);
		return cursor;

	}
	public long addTime(String title,String time,
						String date
	) {
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.Title, title);
			cv.put(Constants.time,time);
			cv.put(Constants.date,date);
			return db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long UpdateTimes(String title,String time,
							String date,int proid) {
		String lla = String.valueOf(proid);
		try {
			ContentValues cv = new ContentValues();
			cv.put(Constants.Title, title);
			cv.put(Constants.time,time);
			cv.put(Constants.date,date);

			return db.update(Constants.TB_NAME,cv,"id=" + proid, null);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Cursor getTimes() {
		String[] columns = {Constants.ROW_ID, Constants.time,
				Constants.date, Constants.Title};
		return db.query(Constants.TB_NAME, columns, null, null, null, null, Constants.ROW_ID +" ASC");
	}
	public void Delete(String tablename,int pos) {
		try {
			db.delete( tablename , "id" + "="  + pos,null);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cursor getSourImages( int id) {

		String[] ids = {String.valueOf(id)};
		String[] columns = {
				Constants.ROW_ID, Constants.SouraNumber,
				SouraId,Constants.ids, ImageID,
				Constants.Soura_gozaa,Constants.Soura_IMage,
				Constants.SouraTafseer,Constants.SouraTelawoa,Constants.SouraName,Constants.urdolang,Constants.page};

		return db.query(Constants.SourDetailsTable, columns, Constants.SouraNumber +"=?", ids,
				null, null, Constants.ids + " ASC");
	}

	public Cursor getSourImages() {

		String[] columns = {Constants.ROW_ID, Constants.SouraNumber,
				SouraId,Constants.ids, ImageID,
				Constants.Soura_gozaa,Constants.Soura_IMage,
				Constants.SouraTafseer,Constants.SouraTelawoa,Constants.SouraName,Constants.urdolang,Constants.page};
		return db.query(Constants.SourDetailsTable, columns, null, null,
				null, null,Constants.ids + " ASC");
	}

	public Cursor getFavourite() {

		String[] columns = {Constants.ROW_ID,
				SouraId,Constants.ids,Constants.SouraName,
				Constants.Pagescount,Constants.AYAT_COUNTER,
				Constants.SouraTafseer,Constants.SouraTelawoa};
		return db.query(Constants.FAV_NAME, columns, null, null,
				null, null,Constants.ROW_ID + " ASC");
	}

	public boolean CheckIsDataAlreadyInDBorNot(String TableName,String dbfield, int fieldValue) {

 		String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
		Cursor cursor = db.rawQuery(Query, null);
		if(cursor.getCount() <= 0){
			cursor.close();
			return false;
		}
		cursor.close();
		return true;
	}

	public boolean CheckIsImageAlreadyInDBorNot(int soraid, int imageid) {

		db = DBhelper.getWritableDatabase();
		String Query = "Select * from " + SourImages + " where " + SouraId + " = " + soraid + " and "+ ImagId +" = " + imageid;
		Cursor cursor = db.rawQuery(Query, null);
		if(cursor.getCount() <= 0){
			cursor.close();
			return false;
		}
		cursor.close();
		return true;
	}

	public int CheckSoraID(String TableName,String dbfield, int fieldValue) {

		String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
		Cursor cursor = db.rawQuery(Query, null);
		if(cursor.getCount() <= 0){
			cursor.close();
			return 999;
		}
		int pos =999;
		while (cursor.moveToNext()) {
			pos = cursor.getInt(1);
		}
			cursor.close();
		return pos;
	}

	public void deletalldata(String TABLE_NAME){
		db.execSQL("delete from "+ TABLE_NAME);

	}

	public String getImagepath(int soraid, int imageid) {

		String Query = "Select * from " + SourImages + " where " + SouraId + " = " + soraid + " and "+ ImagId +" = " + imageid;
		Cursor cursor = db.rawQuery(Query, null);

		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			return cursor.getString(3);
		}
		cursor.close();
		return null;
	}
}