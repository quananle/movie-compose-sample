package com.quanle.movie_sample_compose.data.repository

import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.data.remote.utils.SafeCall
import com.quanle.movie_sample_compose.data.remote.datasource.MovieRemoteDataSource
import com.quanle.movie_sample_compose.domain.repository.IMovieRepository
import com.quanle.movie_sample_compose.utils.wtf
import kotlinx.coroutines.Deferred

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource
): IMovieRepository, SafeCall() {

    init {
        wtf { "when the fuck did MovieRepositoryImpl create?" }
    }

    override suspend fun getMovieAsync(): Result<BaseResponseModel<Any>> {
        return movieRemoteDataSource.getMovieAsync()
    }
}