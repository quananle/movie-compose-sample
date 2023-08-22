package com.quanle.movie_sample_compose.ui.screen.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quanle.movie_sample_compose.domain.usecase.movie.GetListMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieUseCase: GetListMoviesUseCase
): ViewModel() {

    fun discoverMovieAsync() {
        viewModelScope.launch {

        }
    }
}