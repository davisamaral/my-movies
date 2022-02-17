package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.database.cache.MemoryCache
import com.davisamaral.mymovies.movie.domain.model.Movie

internal class MovieMemoryDataSource(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieLocalDataSource, MemoryCache<String, List<Movie>>() {

    override suspend fun getMovies(): List<Movie> {
        return getWithSource(CACHE_KEY) {
            movieRemoteDataSource.getMovies()
        }.orEmpty()
    }

    companion object {
        private const val CACHE_KEY = "MOVIES_CACHE_KEY"
    }
}