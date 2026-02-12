package com.example.mallix.data

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_NAME = "key_name"
        private const val KEY_EMAIL = "key_email"
        private const val KEY_PASSWORD = "key_password"
    }

    var name: String?
        get() = prefs.getString(KEY_NAME, "")
        set(value) = prefs.edit().putString(KEY_NAME, value).apply()

    var email: String?
        get() = prefs.getString(KEY_EMAIL, "")
        set(value) = prefs.edit().putString(KEY_EMAIL, value).apply()

    var password: String?
        get() = prefs.getString(KEY_PASSWORD, "")
        set(value) = prefs.edit().putString(KEY_PASSWORD, value).apply()

    fun clear() {
        prefs.edit().clear().apply()
    }
}