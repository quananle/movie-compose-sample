package com.quanle.movie_sample_compose.domain.usecase.movie

import com.quanle.movie_sample_compose.data.remote.response.Movie
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.domain.repository.IMovieRepository

class GetListMoviesUseCase(private val movieRepository: IMovieRepository) {

    sealed class MovieType(val page: Int) {
        class TopRatedMovies(page: Int) : MovieType(page)
        class UpcomingMovies(page: Int): MovieType(page)
        class PopularMovies(page: Int): MovieType(page)
    }

    suspend operator fun invoke(byType: MovieType): Result<List<Movie>> {
         return when(byType) {
             is MovieType.PopularMovies -> movieRepository.getPopularMovies(byType.page)
             is MovieType.TopRatedMovies -> movieRepository.getTopRatedMovies(byType.page)
             is MovieType.UpcomingMovies -> movieRepository.getUpcomingMovies(byType.page)
         }
    }
}