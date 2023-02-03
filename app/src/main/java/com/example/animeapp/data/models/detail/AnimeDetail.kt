package com.example.animeapp.data.models.detail

import com.example.animeapp.data.models._main.DataItem
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: DataItem
)
