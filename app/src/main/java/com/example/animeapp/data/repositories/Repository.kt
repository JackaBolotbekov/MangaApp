package com.example.animeapp.data.repositories

import com.example.animeapp.base.BaseRepository
import com.example.animeapp.data.remote.apiservice.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val service: ApiService) : BaseRepository() {

    // Методы с помощью кокорых я стягиваю Anime
    fun fetchAnime() = doRequest {
        service.fetchAnime()
    }

    fun fetchAnimeDetail(id: Int) = doRequest {
        service.fetchAnimeDetail(id = id)
    }

    // Методы с помощью кокорых я стягиваю Manga
    fun fetchManga() = doRequest {
        service.fetchManga()
    }

    fun fetchMangaDetail(id: Int) = doRequest {
        service.fetchMangaDetail(id = id)
    }
}