package com.codesroots.elquraan.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PreferenceHelper {

	private SharedPreferences app_prefs;
	private static String app_ref = "quraan";
	private final String Token = "token";
	private final String ID = "id";
	private final String Name = "name";
	private final String isDownloaded = "isdownloaded";
	private final String isAllDataSet = "isAllDataSet";
	private final String SavedPage = "SavedPage";
	private final String LanguageID = "languageid";
	private final String FirstOpen = "FirstOpen";
	private final String soraid = "sora_id_saved";
	private final String savedfind = "savedfind";
	private final String lastpagescrool = "lastpagescrool";
	private final String lastsourashow = "lastsourashow";
	private Context context;

	private final String NEXT_URL = "next_url";

	public PreferenceHelper(Context context) {
		app_prefs = context.getSharedPreferences(app_ref,
				Context.MODE_PRIVATE);
		this.context = context;
	}
	public String getId() {
		return app_prefs.getString(ID, "0");
	}

	public void setFirstOpen(boolean cityID) {
		Editor edit = app_prefs.edit();
		edit.putBoolean(FirstOpen, cityID);
		edit.apply();
	}
	public boolean getFirstOpen() {
		return app_prefs.getBoolean(FirstOpen, false);
	}

	public void setID(String cityID) {
		Editor edit = app_prefs.edit();
		edit.putString(ID, cityID);
		edit.apply();
	}
	public int getSavedPage() {
		return app_prefs.getInt(SavedPage, 0);
	}

	public void setSavedPage(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(SavedPage, savedPage);
		edit.apply();
	}
	public int getSavedfind() {
		return app_prefs.getInt(savedfind, 0);
	}

	public void setsavedfind(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(savedfind, savedPage);
		edit.apply();
	}
	public int getSavedSoraid() {
		return app_prefs.getInt(soraid, 0);
	}

	public int getLastpagescrool() {

		return app_prefs.getInt(lastpagescrool, 0);
	}
	public int getLastsorascrool() {

		return app_prefs.getInt(lastsourashow, 2);
	}

	public void setLastpagescroll(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(lastpagescrool, savedPage);
		edit.apply();
	}
	public void setLastsourashow(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(lastsourashow, savedPage);
		edit.apply();
	}

	public void setSavedSoraid(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(soraid, savedPage);
		edit.apply();
	}

	public int getLanguageID() {
		return app_prefs.getInt(LanguageID, 0);
	}

	public void setLanguageID(int savedPage) {
		Editor edit = app_prefs.edit();
		edit.putInt(LanguageID, savedPage);
		edit.apply();
	}


	public boolean getIsAllDataSet() {
		return app_prefs.getBoolean(isAllDataSet, false);
	}

	public void setIsAllDataSet(boolean cityID) {
		Editor edit = app_prefs.edit();
		edit.putBoolean(isAllDataSet, cityID);
		edit.apply();
	}



	public void setIsDownloaded(boolean cityID) {
		Editor edit = app_prefs.edit();
		edit.putBoolean(isDownloaded, cityID);
		edit.apply();
	}
	public boolean IsDownloaded() {
		return app_prefs.getBoolean(isDownloaded, false);
	}





	public String getToken() {
		return app_prefs.getString(Token,null);
	}





	public void setToken(String API_TOKEN) {
		Editor edit = app_prefs.edit();
		edit.putString(Token, API_TOKEN);
		edit.apply();
	}

	public String getUserName(){
		return app_prefs.getString(Name,null);
	}



	public void setUserName(String name){
		Editor edit = app_prefs.edit();
		edit.putString(Name,name);
		edit.apply();
	}
	



    public void Logout(){
 		setToken(null);
		setID("0");

	}


}
