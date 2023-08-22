package com.quanle.movie_sample_compose.data.remote.utils

import android.util.Log
import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import kotlinx.coroutines.CancellationException
import retrofit2.Response


sealed class Result <T> {
    data class Success<T> (val data: T?) : Result<T>()
    data class Error<T> (val errMsg: String?, val errCode: Int?) : Result<T>()
}

abstract class SafeCall {
    protected suspend fun <T> getResult(call: suspend () -> Response<BaseResponseModel<T>>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val responseBody = response.body()
                return if (responseBody?.results != null)
                    Result.Success(
                        data = responseBody.results
                    )
                else
                    Result.Error(
                        errMsg = responseBody?.status_message,
                        errCode = responseBody?.status_code
                    )
            }
            return Result.Error(errMsg = response.message(), errCode = response.code())
        }
        catch (e: CancellationException) { throw e }
        catch (e: Exception) {
            Log.e("WTF Network Error", "Cause of ${e.message}")
            e.printStackTrace()
            return Result.Error(errMsg = "${e.message}", errCode = null)
        }
    }
}
