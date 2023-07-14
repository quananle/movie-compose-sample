package com.quanle.movie_sample_compose.data.remote

import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.utils.wtf
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface MovieDbService {

    @GET("discover/movie")
    suspend fun discoverMovieAsync() : Response<BaseResponseModel<Any>>

    companion object {
        operator fun invoke(retrofit: Retrofit) : MovieDbService = retrofit.create(MovieDbService::class.java)
        init {
            wtf { "when the fuck did MovieDbService create?" }
        }
    }

}