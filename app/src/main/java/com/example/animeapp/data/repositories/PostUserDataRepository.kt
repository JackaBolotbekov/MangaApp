package com.example.animeapp.data.repositories

import com.example.animeapp.base.BaseRepository
import com.example.animeapp.data.models.auth.AuthModel
import com.example.animeapp.data.remote.apiservices.SignInApiService
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val apiService: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        apiService.postAuthDataUser(authModel)
    }
}