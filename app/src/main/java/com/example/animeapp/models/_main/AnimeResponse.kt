package com.example.animeapp.models._main

import com.google.gson.annotations.SerializedName

data class AnimeResponse<T>(
    @SerializedName("data")
    val data: List<T>,
)