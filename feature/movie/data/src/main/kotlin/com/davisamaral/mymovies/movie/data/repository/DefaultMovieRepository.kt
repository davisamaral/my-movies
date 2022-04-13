package com.davisamaral.mymovies.movie.data.repository

import com.davisamaral.mymovies.movie.data.datasource.MovieLocalDataSource
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.model.MovieDetail
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository

internal class DefaultMovieRepository(
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieRepository {

    override suspend fun getMovieDetail(movieId: Long): MovieDetail? {
        return movieLocalDataSource.getMovieDetail(movieId)
    }

    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return movieLocalDataSource.getPopularMovies(page)
    }
}