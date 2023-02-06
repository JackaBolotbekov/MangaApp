package com.example.animeapp.ui.fragments.manga

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    fun fetchManga() = repository.fetchManga()
}