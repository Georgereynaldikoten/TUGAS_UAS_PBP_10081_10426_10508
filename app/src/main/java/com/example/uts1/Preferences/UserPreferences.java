package com.example.uts1.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uts1.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_NAME = "name";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_NO_TELP = "noTelp";
    public static final String KEY_JENIS_KELAMIN = "jenisKelamin";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    public UserPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(String email, String password, String name, String alamat, String noTelp, String jenisKelamin) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_ALAMAT, alamat);
        editor.putString(KEY_JENIS_KELAMIN, jenisKelamin);
        editor.putString(KEY_NO_TELP, noTelp);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);

        editor.commit();
    }

    public User getUserLogin() {
        String name, password, email, alamat, noTelp, jenisKelamin;

        name = sharedPreferences.getString(KEY_NAME, null);
        alamat = sharedPreferences.getString(KEY_ALAMAT, null);
        jenisKelamin = sharedPreferences.getString(KEY_JENIS_KELAMIN, null);
        noTelp = sharedPreferences.getString(KEY_NO_TELP, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);

        User user = new User();
        user.setEmail(email);
        user.setNoTelp(noTelp);
        user.setJenisKelamin(jenisKelamin);
        user.setAlamat(alamat);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

    public boolean checkLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }
}