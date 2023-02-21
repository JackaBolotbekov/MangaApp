package com.example.animeapp.data.locale.preferences.userdata

import com.example.animeapp.data.locale.preferences.helper.PreferencesHelper

class UserPreferencesData(
    private val preferences: PreferencesHelper,

    private val IS_AUTHORIZED: String = "is_authorized",
    private val ACCESS_TOKEN: String = "access_token",
    private val REFRESH_TOKEN: String = "refresh_token"
) {
    var isAuthorized: Boolean
        get() = preferences().getBoolean(IS_AUTHORIZED, false)
        set(value) = preferences().edit().putBoolean(IS_AUTHORIZED, value).apply()

    var accessToken: String
        get() = preferences().getString(ACCESS_TOKEN, "")!!
        set(value) = preferences().edit().putString(ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = preferences().getString(REFRESH_TOKEN, "")!!
        set(value) = preferences().edit().putString(REFRESH_TOKEN, value).apply()
}