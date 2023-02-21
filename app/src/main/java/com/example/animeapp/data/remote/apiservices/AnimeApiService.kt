package com.example.animeapp.data.remote.apiservices

import com.example.animeapp.data.models.anime.DataItem
import com.example.animeapp.data.models.anime.Response
import com.example.animeapp.data.models.anime.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface  AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): Response<DataItem>

    @GET("edge/anime/{id}")
    suspend fun fetchAnimeDetail(
        @Path("id") id: Int
    ): AnimeDetail

}