package com.example.animeapp.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.animeapp.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}