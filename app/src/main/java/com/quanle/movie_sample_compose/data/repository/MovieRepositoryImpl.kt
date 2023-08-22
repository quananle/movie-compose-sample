package com.quanle.movie_sample_compose.data.repository

import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.data.remote.datasource.MovieRemoteDataSource
import com.quanle.movie_sample_compose.data.remote.response.Movie
import com.quanle.movie_sample_compose.domain.repository.IMovieRepository

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource
): IMovieRepository {
    override suspend fun getPopularMovies(page: Int): Result<List<Movie>> {
        return movieRemoteDataSource.getPopularMovies()
    }

    override suspend fun getTopRatedMovies(page: Int): Result<List<Movie>> {
        return movieRemoteDataSource.getTopRatedMovies()
    }

    override suspend fun getUpcomingMovies(page: Int): Result<List<Movie>> {
        return movieRemoteDataSource.getUpcomingMovies()
    }
}