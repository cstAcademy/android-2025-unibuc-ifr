package com.cst.unibucifr2025.managers

import com.cst.unibucifr2025.ApplicationController

object SharedPrefsManager {

    private const val KEY_AUTH_TOKEN = "auth_token"

    fun saveAuthToken(token: String) = sharedPrefs?.let { sp ->
        with(sp.edit()) {
            putString(KEY_AUTH_TOKEN, token)
            apply()
        }
    }

    fun getAuthToken(): String? = sharedPrefs?.getString(KEY_AUTH_TOKEN, null)

    private val sharedPrefs
        get() = ApplicationController.instance?.sharedPrefs
}