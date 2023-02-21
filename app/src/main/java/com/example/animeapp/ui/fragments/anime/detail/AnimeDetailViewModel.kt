package com.example.animeapp.ui.fragments.anime.detail

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val animeRepository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnimeDetail(id: Int) = animeRepository.fetchAnimeDetail(id = id)
}