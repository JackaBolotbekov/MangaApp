package com.example.animeapp.ui.fragments.anime.detail

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    fun fetchAnimeDetail(id: Int) = repository.fetchAnimeDetail(id)
}