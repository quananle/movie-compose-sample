package com.quanle.movie_sample_compose.data.remote.response

data class BaseResponseModel<T> (
    val success: Boolean,
    val status_code: Int,
    val status_message: String,
    val results: T?,
)