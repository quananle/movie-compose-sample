package com.quanle.movie_sample_compose.domain.usecase

import com.quanle.movie_sample_compose.data.repository.MovieRepositoryImpl
import com.quanle.movie_sample_compose.domain.repository.IMovieRepository
import com.quanle.movie_sample_compose.utils.wtf

class MovieUseCase(
   private val movieRepository: IMovieRepository
) {
    init {
        wtf { "when the fuck did MovieUseCase create?" }
    }

    suspend fun getMoviesAsync() = movieRepository.getMovieAsync()
}