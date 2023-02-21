package com.example.animeapp.data.remote.apiservices

import com.example.animeapp.data.models.auth.AuthModel
import com.example.animeapp.data.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}
