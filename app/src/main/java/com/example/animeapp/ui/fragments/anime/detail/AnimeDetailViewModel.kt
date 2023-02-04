package com.example.animeapp.ui.fragments.anime.detail

import androidx.lifecycle.ViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun fetchAnimeDetail(id: Int) = repository.fetchAnimeDetail(id)
}