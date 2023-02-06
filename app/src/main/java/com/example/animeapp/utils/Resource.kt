package com.example.animeapp.utils

/* ДО
sealed class Resource<T>(
    var data: T? = null,
    var message: String
) {
    class Loading<T>(data: T? = null, message: String = "") : Resource<T>(null, "")

    class Success<T>(data: T, message: String = "") : Resource<T>(data, message)

    class Error<T>(data: T?, message: String = "") : Resource<T>(data, message)
}
*/// После

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}