package com.example.animeapp.ui.fragments.anime

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}