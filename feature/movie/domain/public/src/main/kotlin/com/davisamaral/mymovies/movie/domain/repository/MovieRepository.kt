package com.davisamaral.mymovies.movie.domain.repository

import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getPopularMovies(page: Int = 1): List<Movie>
    suspend fun getMovieDetail(movieId: Long): MovieDetail?
}