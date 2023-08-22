package com.quanle.movie_sample_compose.data.remote.datasource

import com.quanle.movie_sample_compose.data.remote.MovieDbService
import com.quanle.movie_sample_compose.data.remote.utils.SafeCall
import com.quanle.movie_sample_compose.utils.wtf

class MovieRemoteDataSource(
    private val movieDbService: MovieDbService
): SafeCall() {

    suspend fun getPopularMovies(
        page: Int = 1
    ) = getResult {
        movieDbService.getPopularMovies(page)
    }

    suspend fun getTopRatedMovies(
        page: Int = 1
    ) = getResult {
        movieDbService.getTopRatedMovies(page)
    }

    suspend fun getUpcomingMovies(
        page: Int = 1
    ) = getResult {
        movieDbService.getUpcomingMovies(page)
    }

}