package com.quanle.movie_sample_compose.di

import com.quanle.movie_sample_compose.domain.repository.IMovieRepository
import com.quanle.movie_sample_compose.domain.usecase.movie.GetListMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    // TODO: UseCase might not a singleton
    init {
        //wtf { "when the fuck did UseCaseModule create?" }
    }

    @Provides
    @Singleton
    fun provideUseCase(
        movieRepository: IMovieRepository
    ): GetListMoviesUseCase = GetListMoviesUseCase(movieRepository)


}