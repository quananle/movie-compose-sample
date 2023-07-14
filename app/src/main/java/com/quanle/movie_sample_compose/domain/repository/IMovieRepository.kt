package com.quanle.movie_sample_compose.domain.repository

import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.utils.wtf
import kotlinx.coroutines.Deferred

interface IMovieRepository {
    suspend fun getMovieAsync() : Result<BaseResponseModel<Any>>

    companion object {
        init {
            wtf { "when the fuck did IMovieRepository create?" }
        }
    }
}