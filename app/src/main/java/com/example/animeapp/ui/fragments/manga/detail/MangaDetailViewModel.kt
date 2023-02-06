package com.example.animeapp.ui.fragments.manga.detail

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    fun fetchMangaDetail(id: Int) = repository.fetchMangaDetail(id)
}