package com.example.animeapp.models._main

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String = "",
)