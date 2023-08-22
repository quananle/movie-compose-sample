package com.quanle.movie_sample_compose.domain.repository

import com.quanle.movie_sample_compose.data.remote.response.Movie
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.utils.wtf

interface IMovieRepository {
    suspend fun getPopularMovies(
        page: Int = 1
    ) : Result<List<Movie>>

    suspend fun getTopRatedMovies(
        page: Int = 1
    ) : Result<List<Movie>>

    suspend fun getUpcomingMovies(
        page: Int = 1
    ) : Result<List<Movie>>

}