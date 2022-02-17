package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.movie.domain.model.Movie

interface MovieLocalDataSource {
    suspend fun getMovies(): List<Movie>
}