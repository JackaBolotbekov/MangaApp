package com.example.animeapp.data.remote.apiservice

import com.example.animeapp.data.models.anime.AnimeResponse
import com.example.animeapp.data.models.anime.DataItem
import com.example.animeapp.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

    @GET("anime/{id}")
    suspend fun fetchAnimeDetail(
        @Path("id") id: Int
    ): AnimeDetail
}