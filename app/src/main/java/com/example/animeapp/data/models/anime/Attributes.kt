package com.example.animeapp.data.models.anime

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("titles")
    val titles: Titles,
)