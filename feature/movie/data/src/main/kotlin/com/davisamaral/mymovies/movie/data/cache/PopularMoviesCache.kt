package com.davisamaral.mymovies.movie.data.cache

import com.davisamaral.mymovies.database.cache.MemoryCache
import com.davisamaral.mymovies.movie.domain.model.Movie

class PopularMoviesCache : MemoryCache<String, List<Movie>>() {

    suspend fun getPopularMovies(page: Int, source: suspend () -> List<Movie>): List<Movie> {
        return getWithSource("$POPULAR_MOVIES_CACHE_KEY\\_PAGE=$page") {
            source()
        }.orEmpty()
    }

    companion object {
        private const val POPULAR_MOVIES_CACHE_KEY = "POPULAR_MOVIES_CACHE_KEY"
    }
}