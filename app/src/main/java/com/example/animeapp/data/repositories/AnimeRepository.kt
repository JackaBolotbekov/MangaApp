package com.example.animeapp.data.repositories

import androidx.lifecycle.liveData
import com.example.animeapp.data.remote.apiservice.AnimeApiService
import com.example.animeapp.models._main.AnimeResponse
import com.example.animeapp.models._main.DataItem
import com.example.animeapp.models.detail.AnimeDetail
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) {

    fun fetchAnime() = liveData {
        emit(service.fetchAnime())
    }

    fun fetchAnimeDetail(id: Int) = liveData {
        emit(service.fetchAnimeDetail(id = id))
    }
}