package com.quanle.movie_sample_compose.data.remote.utils

import com.quanle.movie_sample_compose.di.NetworkModule
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor (
    @NetworkModule.ApiKeyQualifier private val apikey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain
        .request()
        .newBuilder()
        .addHeader("Authorization", "Bearer $apikey")
        .build()
        .let(chain::proceed)
}