package com.davisamaral.mymovies.movie.domain.repository

import com.davisamaral.mymovies.movie.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}