package com.quanle.movie_sample_compose.ui.screen.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quanle.movie_sample_compose.domain.usecase.MovieUseCase
import com.quanle.movie_sample_compose.utils.wtf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
): ViewModel() {

    init {
        wtf { "when the fuck did MovieDetailViewModel create?" }

    }

    fun discoverMovieAsync() {
        viewModelScope.launch {

        }
    }

    override fun onCleared() {
        super.onCleared()
        wtf { "\nwhen the fuck did MovieDetailViewModel onClear?\n" }
    }
}