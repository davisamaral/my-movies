package com.davisamaral.mymovies.movie.data.api

import com.davisamaral.mymovies.movie.data.api.model.MovieDetailResponse
import com.davisamaral.mymovies.movie.data.api.model.MovieResponse
import com.davisamaral.mymovies.network.retrofit.PageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1,
    ): Call<PageResponse<MovieResponse>?>?

    @GET("movie/{movieId}")
    fun getMovieDetail(
        @Path("movieId") movieId: Long,
        @Query("api_key") apiKey: String,
    ): Call<MovieDetailResponse>?
}