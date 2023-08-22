package com.quanle.movie_sample_compose.data.remote

import com.quanle.movie_sample_compose.data.remote.response.BaseResponseModel
import com.quanle.movie_sample_compose.data.remote.response.Movie
import com.quanle.movie_sample_compose.utils.wtf
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): Response<BaseResponseModel<List<Movie>>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int
    ): Response<BaseResponseModel<List<Movie>>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int
    ): Response<BaseResponseModel<List<Movie>>>

    companion object {
        operator fun invoke(retrofit: Retrofit) : MovieDbService = retrofit.create(MovieDbService::class.java)

    }

}