package com.davisamaral.mymovies.movie.data.cache

import com.davisamaral.mymovies.database.cache.MemoryCache
import com.davisamaral.mymovies.movie.domain.model.MovieDetail

class MovieDetailCache : MemoryCache<String, MovieDetail?>() {

    suspend fun getMoviesDetail(
        movieId: Long,
        source: suspend () -> MovieDetail?
    ): MovieDetail? {
        return getWithSource("$MOVIE_DETAIL_CACHE_KEY\\_$movieId") {
            source()
        }
    }

    companion object {
        private const val MOVIE_DETAIL_CACHE_KEY = "MOVIE_DETAIL_CACHE_KEY"
    }
}