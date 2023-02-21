package com.example.animeapp.base

import com.example.animeapp.utils.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Error(ioException.localizedMessage ?: "Error"))
        }
    }
}