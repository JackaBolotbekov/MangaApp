package com.example.animeapp.ui.fragments.signup

import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.data.models.auth.AuthModel
import com.example.animeapp.data.repositories.PostUserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: PostUserDataRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}