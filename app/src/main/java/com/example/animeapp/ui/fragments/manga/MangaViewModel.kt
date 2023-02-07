package com.example.animeapp.ui.fragments.manga

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import com.example.animeapp.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val mangaRepository: MangaRepository) :
    BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga()
}