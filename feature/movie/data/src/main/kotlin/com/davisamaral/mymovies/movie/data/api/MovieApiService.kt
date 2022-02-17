package com.davisamaral.mymovies.movie.data.api

import com.davisamaral.mymovies.movie.data.api.model.MovieResponse
import com.davisamaral.mymovies.network.retrofit.PageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Call<PageResponse<MovieResponse>?>?
}