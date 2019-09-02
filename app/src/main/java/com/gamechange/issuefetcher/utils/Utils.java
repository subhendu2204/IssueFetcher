package com.gamechange.issuefetcher.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gamechange.issuefetcher.storage.StorageManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static boolean isNetworkAvailable(){
        Context context = AppInstance.getAppInstance().getAppContext();

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!= null && networkInfo.isConnected();

    }

    public static boolean isCacheExpired(){
        long currentTime = Calendar.getInstance().getTimeInMillis();
        //get last saved time
        long lastCachedTime = StorageManager.getInstance().getCacheTime();
        //check more than 24 hours
        if(currentTime - lastCachedTime >= 24*60*60*1000){
            return true;
        }else{
            return false;
        }
    }

    public static Date getParsedDate(String date, String format){
        try {
            return new SimpleDateFormat(format, Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
