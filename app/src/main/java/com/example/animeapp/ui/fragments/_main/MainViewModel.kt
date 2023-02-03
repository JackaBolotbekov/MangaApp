package com.example.animeapp.ui.fragments._main

import androidx.lifecycle.ViewModel
import com.example.animeapp.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}