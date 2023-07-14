package com.quanle.movie_sample_compose.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.quanle.movie_sample_compose.BuildConfig
import com.quanle.movie_sample_compose.data.remote.utils.AuthorizationInterceptor
import com.quanle.movie_sample_compose.data.remote.MovieDbService
import com.quanle.movie_sample_compose.utils.wtf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    init {
        wtf { "when the fuck did NetworkModule create?" }
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BaseUrlQualifier

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApiKeyQualifier

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_KEY = "JhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NDg0Y2U0MzhkOTYxNGFmODE5MzhlOWRkODI1MzYxOSIsInN1YiI6IjY0YWY2MzBhYTQxMGM4MDBlNTU3Y2ZhNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AYhB5yWkdYlhBhY5QRV_pl488ZEyOJ2dLyGouU_PS6U"
    private const val TIMEOUT: Long = 30

    @Provides
    @BaseUrlQualifier
    fun provideBaseUrl() : String = BASE_URL

    @Provides
    @ApiKeyQualifier
    fun provideApiKey() : String = API_KEY

    @Provides
    fun loggingInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

    }

    @Provides
    @Singleton
    fun okhttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authorizationInterceptor: AuthorizationInterceptor
    ) : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(authorizationInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun retrofit(
        @BaseUrlQualifier baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun movieDbService(
        retrofit: Retrofit
    ): MovieDbService {
        return MovieDbService(retrofit = retrofit)
    }
}