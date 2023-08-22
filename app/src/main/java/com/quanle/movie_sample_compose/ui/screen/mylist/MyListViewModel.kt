package com.quanle.movie_sample_compose.ui.screen.mylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.domain.usecase.movie.GetListMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor (
    private val getMovieUseCase: GetListMoviesUseCase
): ViewModel() {

    private var _movies = MutableLiveData<Result<BaseResponseModel<Any>>>()
    val movies: LiveData<Result<BaseResponseModel<Any>>> get() = _movies

}