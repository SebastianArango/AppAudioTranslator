package com.co.dayron.translatoraudioapp.helper;

import android.content.Context;

/**
 * Created by dayron on 9/4/15.
 */
public class InstanceSingleton {
    private static InstanceSingleton instanceSingleton = null;

    private Context mContext;

    private InstanceSingleton(Context context) {
        mContext = context;
    }


    public static void setInstanceSingleton(Context context) {
        if (instanceSingleton == null) {
            instanceSingleton = new InstanceSingleton(context);
        }
    }


    public static InstanceSingleton getInstanceSingleton() {
        return instanceSingleton;
    }


    public Context getmContext() {
        return this.mContext;
    }
}
