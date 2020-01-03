package com.mykiddo.app.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class PreferenceUtil {


        public static Context mcontext;
        static public void setPreferenceObject(Context c, Object modal,String key) {
            /**** storing object in preferences  ****/
            SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());
            SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
            Gson gson = new Gson();
            String jsonObject = gson.toJson(modal);
            prefsEditor.putString(key, jsonObject);
            prefsEditor.commit();

        }
        static public void clearPreferenceObject(Context c) {
            getSharedPreferences(c).edit().clear().apply();
        }
        public static SharedPreferences getSharedPreferences(Context context) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }

        public static String getAccessTokenFromServer(Context context) {
            return getSharedPreferences(context).getString(Constants.PreferenceConstants.TOKEN, "");
        }

        public static void setAccessTokenFromServer(Context context, String useremail) {
            getSharedPreferences(context).edit().putString(Constants.PreferenceConstants.TOKEN, useremail).apply();
        }
    }


