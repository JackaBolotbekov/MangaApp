package com.example.animeapp.data.repositories

import androidx.lifecycle.liveData
import com.example.animeapp.data.remote.apiservice.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) {

    fun fetchAnime() = liveData {
        emit(service.fetchAnime())
    }

    fun fetchAnimeDetail(id: Int) = liveData {
        emit(service.fetchAnimeDetail(id = id))
    }
}