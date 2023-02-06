package com.example.animeapp.data.remote.apiservice

import com.example.animeapp.data.models.anime.AnimeResponse
import com.example.animeapp.data.models.anime.DataItem
import com.example.animeapp.data.models.anime.detail.AnimeDetail
import com.example.animeapp.data.models.anime.detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

    @GET("anime/{id}")
    suspend fun fetchAnimeDetail(
        @Path("id") id: Int
    ): AnimeDetail

    @GET("manga")
    suspend fun fetchManga(): AnimeResponse<DataItem>

    @GET("manga/{id}")
    suspend fun fetchMangaDetail(
        @Path("id") id: Int
    ): MangaDetail
}