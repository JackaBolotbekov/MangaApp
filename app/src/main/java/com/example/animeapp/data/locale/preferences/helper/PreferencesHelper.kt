package com.example.animeapp.data.locale.preferences.helper

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val preferenceHelper: SharedPreferences =
        context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)

    operator fun invoke() = preferenceHelper
}