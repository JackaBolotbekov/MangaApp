package com.example.animeapp.ui.fragments.anime

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val animeRepository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}