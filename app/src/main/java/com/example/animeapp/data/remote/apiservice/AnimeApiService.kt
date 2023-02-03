package com.example.animeapp.data.remote.apiservice

import com.example.animeapp.models._main.AnimeResponse
import com.example.animeapp.models._main.DataItem
import com.example.animeapp.models.detail.AnimeDetail
import retrofit2.Call
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