package com.quanle.movie_sample_compose.di

import com.quanle.movie_sample_compose.data.remote.MovieDbService
import com.quanle.movie_sample_compose.data.remote.datasource.MovieRemoteDataSource
import com.quanle.movie_sample_compose.utils.wtf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

 @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        movieDbService: MovieDbService
    ) = MovieRemoteDataSource(movieDbService)

}