package com.example.animeapp.data.remote

import com.example.animeapp.data.remote.apiservices.AnimeApiService
import com.example.animeapp.data.remote.apiservices.MangaApiService
import com.example.animeapp.data.remote.apiservices.SignInApiService
import com.example.animeapp.data.repositories.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(TokenInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService(): AnimeApiService = retrofitClient.create(AnimeApiService::class.java)
    fun provideMangaApiService(): MangaApiService = retrofitClient.create(MangaApiService::class.java)
    fun providerSignInApiService(): SignInApiService = retrofitClient.create(SignInApiService::class.java)
}