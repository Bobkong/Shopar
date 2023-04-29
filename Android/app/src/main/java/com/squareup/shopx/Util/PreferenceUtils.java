package com.squareup.shopx.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

/**
 * This provides methods to manage preferences data.
 */
public class PreferenceUtils {

    private static final String PREFERENCE_KEY_PHONE = "PREFERENCE_KEY_PHONE";
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    // Prevent instantiation
    private PreferenceUtils() {
    }

    public static void init(@NonNull Context appContext) {
        context = appContext.getApplicationContext();
    }

    private static SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences("sendbird", Context.MODE_PRIVATE);
    }

    public static void setUserPhone(@NonNull String userPhone) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(PREFERENCE_KEY_PHONE, userPhone).apply();
    }

    @NonNull
    public static String getUserPhone() {
        final String result = getSharedPreferences().getString(PREFERENCE_KEY_PHONE, "");
        return result == null ? "" : result;
    }

    public static void clearAll() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear().apply();
    }
}
