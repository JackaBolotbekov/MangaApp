package com.example.animeapp.data.repositories

import com.example.animeapp.base.BaseRepository
import com.example.animeapp.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    // Методы с помощью кокорых я стягиваю Manga
    fun fetchManga() = doRequest {
        service.fetchManga()
    }

    fun fetchMangaDetail(id: Int) = doRequest {
        service.fetchMangaDetail(id = id)
    }
}