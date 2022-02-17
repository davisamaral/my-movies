package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.movie.domain.model.Movie

interface MovieRemoteDataSource {
    suspend fun getMovies(): List<Movie>
}