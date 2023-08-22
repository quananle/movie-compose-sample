package com.quanle.movie_sample_compose.ui.screen.home

import com.quanle.movie_sample_compose.data.remote.response.Movie

data class HomeState (
    val isLoading: Boolean = false,
    val popularMovies: List<Movie>? = null,
    val popularMoviesError: String? = null,
    val upcomingMovies: List<Movie>? = null,
    val topRatedMovies: List<Movie>? = null
)