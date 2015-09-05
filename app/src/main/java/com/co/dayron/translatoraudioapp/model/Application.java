package com.co.dayron.translatoraudioapp.model;

import android.content.SharedPreferences;

/**
 * Created by dayron on 9/4/15.
 */
public class Application extends android.app.Application {

    private static Application instance;
    SharedPreferences mPref;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    private void initializeInstance() {
        // Do your application wise initialization task
        //screenConfiguration();
        // set application wise preference
        mPref = this.getApplicationContext().getSharedPreferences("pref_key", MODE_PRIVATE);
    }
}
