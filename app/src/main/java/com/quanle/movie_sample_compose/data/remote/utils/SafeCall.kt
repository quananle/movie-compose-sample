package com.quanle.movie_sample_compose.data.remote.utils

import kotlinx.coroutines.CancellationException
import retrofit2.Response


sealed class Result <T> {
    object Loading : Result<Nothing>()
    data class Success<T> (val data: T?) : Result<T>()
    data class Error<T> (val errMsg: String?, val errCode: Int?) : Result<T>()
}

abstract class SafeCall {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null)
                    return Result.Success(body)
            }
            return Result.Error(errMsg = response.message(), errCode = response.code())
        }
        catch (e: CancellationException) { throw e }
        catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(errMsg = "${e.message}", errCode = null)
        }
    }
}
