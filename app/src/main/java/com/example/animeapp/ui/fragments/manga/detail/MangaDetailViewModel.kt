package com.example.animeapp.ui.fragments.manga.detail

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import com.example.animeapp.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val mangaRepository: MangaRepository) :
    BaseViewModel() {

    fun fetchMangaDetail(id: Int) = mangaRepository.fetchMangaDetail(id)
}