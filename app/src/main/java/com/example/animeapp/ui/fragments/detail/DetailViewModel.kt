package com.example.animeapp.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun fetchAnimeDetail(id: Int) = repository.fetchAnimeDetail(id)
}