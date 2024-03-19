package com.affan.bcas_app.utils

import android.content.Context
import android.content.SharedPreferences

class SharePrefHelper(context:Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token:String) {
        sharedPref.edit().putString(TOKEN_KEY, token).apply()

    }

    fun getToken(): String {
        return sharedPref.getString(TOKEN_KEY, null) ?:""
    }

    fun clearDataPref() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        const val TOKEN_KEY = "key_name"
        const val  PREF_NAME = "pref_name"
    }
}