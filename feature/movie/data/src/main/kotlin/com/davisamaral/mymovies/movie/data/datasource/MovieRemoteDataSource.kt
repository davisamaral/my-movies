package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.model.MovieDetail

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int = 1): List<Movie>
    suspend fun getMovieDetail(movieId: Long): MovieDetail?
}