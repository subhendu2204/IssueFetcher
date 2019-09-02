package com.gamechange.issuefetcher.utils;

import android.app.Application;
import android.content.Context;

public class AppInstance extends Application {
    private static AppInstance appInstance;

    public static AppInstance getAppInstance(){
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public Context getAppContext(){
        return appInstance.getApplicationContext();
    }


}
