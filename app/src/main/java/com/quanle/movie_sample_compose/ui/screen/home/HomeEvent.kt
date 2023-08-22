package com.quanle.movie_sample_compose.ui.screen.home

import com.quanle.movie_sample_compose.data.remote.response.Movie

sealed class HomeEvent {
    class Loading(
        val isLoading: Boolean
    ) : HomeEvent()
    class PopularMoviesLoaded(
        val popularMovies: List<Movie>?,
    ): HomeEvent()
    class UpcomingMoviesLoaded(
        val upcomingMovies: List<Movie>?,
    ): HomeEvent()
    class TopRatedMoviesLoaded(
        val topRatedMovies: List<Movie>?,
    ): HomeEvent()

    class NetworkError(
        val errMsg: String?
    ): HomeEvent()
}