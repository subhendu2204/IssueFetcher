package com.gamechange.issuefetcher.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.gamechange.issuefetcher.utils.AppInstance;


public class SPHelper {
    public final static String PREFIX = "gamechanger";
    public final static String ISSUE_LIST = "ISSUE_LIST";
    public final static String CACHE_TIME = "CACHE_TIME";
    private SharedPreferences sharedPreferences;
    private static SPHelper helper;

    private SPHelper(){
        Context context = AppInstance.getAppInstance().getAppContext();
        sharedPreferences = context.getSharedPreferences(PREFIX, Context.MODE_PRIVATE);
    }

    public static SPHelper getInstance(){
        if(helper == null){
            helper = new SPHelper();
        }
        return helper;
    }

    public void saveString(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public void saveLong(String key, Long value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key){
        return sharedPreferences.getLong(key, 0L);
    }

}
