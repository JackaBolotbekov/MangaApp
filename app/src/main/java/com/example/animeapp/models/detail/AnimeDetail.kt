package com.example.animeapp.models.detail

import com.example.animeapp.models._main.DataItem
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: DataItem
)
