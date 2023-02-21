package com.example.animeapp.data.repositories

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    private val accessToken: String = "access_token"

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter(
                    "Authorization:",
                    "Bearer $accessToken"
                )
                .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}