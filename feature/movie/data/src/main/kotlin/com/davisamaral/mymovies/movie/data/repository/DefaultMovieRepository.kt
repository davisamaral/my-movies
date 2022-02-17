package com.davisamaral.mymovies.movie.data.repository

import com.davisamaral.mymovies.movie.data.datasource.MovieLocalDataSource
import com.davisamaral.mymovies.movie.data.datasource.MovieRemoteDataSource
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository

internal class DefaultMovieRepository(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return movieLocalDataSource.getMovies()
    }
}