package com.example.animeapp.data.models.auth

import com.google.gson.annotations.SerializedName

data class TokenModel(

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

)
