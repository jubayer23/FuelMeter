package com.creative.fuelmeter.sharedprefs;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PrefManager {
    private static final String TAG = PrefManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "com.creative.namajihelper";
    // Sharedpref file name
    private static final String KEY_FUEL_CONSUMED_PER_KM = "fuel_consumed_per_km";
    private static final String KEY_FUEL_PRICE_PER_KM = "fuel_price_per_km";

    // Google's username
    private static final String KEY_LOGIN_TYPE = "login_type";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

    }

    public void setLoginType(String type) {
        editor = pref.edit();

        editor.putString(KEY_LOGIN_TYPE, type);

        // commit changes
        editor.commit();
    }

    public String getLoginType() {
        return pref.getString(KEY_LOGIN_TYPE, "");
    }

    public void setFuelConsumedPerKm(float value) {
        editor = pref.edit();

        editor.putFloat(KEY_FUEL_CONSUMED_PER_KM, value);

        // commit changes
        editor.commit();
    }

    public float getFuelConsumedPerKm() {
        return pref.getFloat(KEY_FUEL_CONSUMED_PER_KM, 0);
    }

    public void setFuelPrice(float value) {
        editor = pref.edit();

        editor.putFloat(KEY_FUEL_PRICE_PER_KM, value);

        // commit changes
        editor.commit();
    }

    public Float getFuelPrice() {
        return pref.getFloat(KEY_FUEL_PRICE_PER_KM, 0);
    }


}