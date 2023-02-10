package com.example.animeapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.animeapp.base.BaseRepository
import com.example.animeapp.data.remote.apiservices.MangaApiService
import com.example.animeapp.data.remote.pagingsources.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(private val mangaApiService: MangaApiService) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSource(mangaApiService)
    }.liveData

    fun fetchMangaDetail(id: Int) = doRequest {
        mangaApiService.fetchMangaDetail(id = id)
    }
}