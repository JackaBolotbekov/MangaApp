package com.example.animeapp.data.repositories

import com.example.animeapp.base.BaseRepository
import com.example.animeapp.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    // Методы с помощью кокорых я стягиваю Anime
    fun fetchAnime() = doRequest {
        service.fetchAnime()
    }

    fun fetchAnimeDetail(id: Int) = doRequest {
        service.fetchAnimeDetail(id = id)
    }
}