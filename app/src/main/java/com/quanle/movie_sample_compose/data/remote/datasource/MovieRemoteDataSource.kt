package com.quanle.movie_sample_compose.data.remote.datasource

import com.quanle.movie_sample_compose.data.remote.MovieDbService
import com.quanle.movie_sample_compose.data.remote.utils.SafeCall
import com.quanle.movie_sample_compose.utils.wtf

class MovieRemoteDataSource(
    private val movieDbService: MovieDbService
): SafeCall() {

    init {
        wtf { "when the fuck did MovieRemoteDataSource create?" }
    }

    suspend fun getMovieAsync() = getResult {
        movieDbService.discoverMovieAsync()
    }

}