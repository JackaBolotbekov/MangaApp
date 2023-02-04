package com.example.animeapp.data.models.anime

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("original")
    val original: String = "",
)