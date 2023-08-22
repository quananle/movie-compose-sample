package com.quanle.movie_sample_compose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.domain.usecase.movie.GetListMoviesUseCase
import com.quanle.movie_sample_compose.domain.usecase.movie.GetListMoviesUseCase.MovieType.*
import com.quanle.movie_sample_compose.utils.wtf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListMovies: GetListMoviesUseCase
) : ViewModel() {

    var homeUiState = MutableStateFlow(HomeState())

    private fun call(event: HomeEvent) {
        onEventCalled(event)
    }
    private fun onEventCalled(event: HomeEvent) {
        when(event){
            is HomeEvent.Loading -> {
                homeUiState.value = homeUiState.value.copy(isLoading = true)
            }
            is HomeEvent.PopularMoviesLoaded -> {
                wtf {  "PopularMoviesLoaded "}
                homeUiState.value  = homeUiState.value.copy(popularMovies = event.popularMovies)
            }
            is HomeEvent.TopRatedMoviesLoaded -> {
                wtf {  "TopRatedMoviesLoaded "}
                homeUiState.value  = homeUiState.value.copy(topRatedMovies = event.topRatedMovies)
            }
            is HomeEvent.UpcomingMoviesLoaded -> {
                wtf {  "PopularMoviesLoaded "}
                homeUiState.value  = homeUiState.value.copy(upcomingMovies = event.upcomingMovies)
            }
            is HomeEvent.NetworkError -> {
                homeUiState.value  = homeUiState.value.copy(popularMoviesError = event.errMsg)
            }
        }
    }

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            homeUiState.value = homeUiState.value.copy(isLoading = true)
            loadUpcomingMovies()
            loadPopularMovies()
            loadTopRatedMovies()
        }
    }

    private fun loadPopularMovies(page: Int = 1) {
        viewModelScope.launch {
            getListMovies(
                byType = PopularMovies(
                    page
                )
            ).let { resultOfPopularMovies ->
                when(resultOfPopularMovies) {
                    is Result.Success -> call(HomeEvent.PopularMoviesLoaded(resultOfPopularMovies.data))
                    is Result.Error -> call(HomeEvent.NetworkError(resultOfPopularMovies.errMsg))
                }
            }
        }
    }

    private fun loadTopRatedMovies(page: Int = 1) {
        viewModelScope.launch {
            getListMovies(
                byType = TopRatedMovies(
                    page
                )
            ).let { resultOfTopRatedMovies ->
                when(resultOfTopRatedMovies) {
                    is Result.Success -> call(HomeEvent.TopRatedMoviesLoaded(resultOfTopRatedMovies.data))
                    is Result.Error -> call(HomeEvent.NetworkError(resultOfTopRatedMovies.errMsg))
                }
            }
        }
    }


    private fun loadUpcomingMovies(page: Int = 1) {
        viewModelScope.launch {
            getListMovies(
                byType = UpcomingMovies(
                    page
                )
            ).let { resultOfUpcomingMovies ->
                when(resultOfUpcomingMovies) {
                    is Result.Success -> call(HomeEvent.UpcomingMoviesLoaded(resultOfUpcomingMovies.data))
                    is Result.Error -> call(HomeEvent.NetworkError(resultOfUpcomingMovies.errMsg))
                }
            }
        }
    }
}