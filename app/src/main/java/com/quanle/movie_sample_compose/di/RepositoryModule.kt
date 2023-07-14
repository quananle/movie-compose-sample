package com.quanle.movie_sample_compose.di

import com.quanle.movie_sample_compose.data.remote.MovieDbService
import com.quanle.movie_sample_compose.data.remote.datasource.MovieRemoteDataSource
import com.quanle.movie_sample_compose.data.repository.MovieRepositoryImpl
import com.quanle.movie_sample_compose.domain.repository.IMovieRepository
import com.quanle.movie_sample_compose.utils.wtf
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    init {
        wtf { "when the fuck did RepositoryModule create?" }
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource
    ): IMovieRepository = MovieRepositoryImpl(movieRemoteDataSource)

}
