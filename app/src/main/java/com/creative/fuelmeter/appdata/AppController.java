package com.creative.fuelmeter.appdata;

import android.app.Application;
import android.text.TextUtils;

import com.creative.fuelmeter.sharedprefs.PrefManager;


public class AppController extends Application {


    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;

    private PrefManager pref;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        pref = new PrefManager(this);

        // FacebookSdk.sdkInitialize(getApplicationContext());

    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public PrefManager getPrefManger() {
        if (pref == null) {
            pref = new PrefManager(this);
        }

        return pref;
    }



}