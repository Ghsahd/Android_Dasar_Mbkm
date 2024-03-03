package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String KEY_EMAIL = "email";
    static final String KEY_PASSWORD = "password";
    static final String KEY_NAMA_LENGKAP = "nama_lengkap";
    static final String KEY_USERNAME = "username";

    // Simpan sesi login
    public static void saveLoginSession(Context context, String email, String password) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }
    //simpan register
    public static void saveDataRegister(Context context, String namaLengkap, String email, String password, String username) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(KEY_NAMA_LENGKAP, namaLengkap);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }
}