package com.quanle.movie_sample_compose.ui.screen.mylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.data.remote.utils.Result
import com.quanle.movie_sample_compose.domain.usecase.MovieUseCase
import com.quanle.movie_sample_compose.utils.wtf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor (
    private val movieUseCase: MovieUseCase
): ViewModel() {

    private var _movies = MutableLiveData<Result<BaseResponseModel<Any>>>()
    val movies: LiveData<Result<BaseResponseModel<Any>>> get() = _movies
    init {
        wtf { "when the fuck did MyListViewModel create?" }
    }



    override fun onCleared() {
        super.onCleared()
        wtf { "\nwhen the fuck did MyListViewModel onClear?\n" }
    }
}