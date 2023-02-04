package com.example.animeapp.data.models.anime

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(
    @SerializedName("data")
    val data: List<T>,
)