package com.hsk4dictionary.android;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * Created by pjhjohn on 2015-05-07.
 * MontserratApp.onCreate handles application initialization which should be called once.
 */
public class HSK4DictionaryApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /* Timber */
        Timber.plant(new Timber.DebugTree());

        /* Picasso Debugging flags */
        Picasso.with(getApplicationContext()).setIndicatorsEnabled(BuildConfig.DEBUG);
        Picasso.with(getApplicationContext()).setLoggingEnabled(BuildConfig.DEBUG);
    }

    /*
     * MultiDex Support for Pre-Lolipop devices to prevent possible crash with 65536+ methods
     * in build.gradle - dependency : compile 'com.android.support:multidex:1.0.1'
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
