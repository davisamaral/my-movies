package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.movie.data.cache.MovieDetailCache
import com.davisamaral.mymovies.movie.data.cache.PopularMoviesCache
import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.model.MovieDetail

internal class MovieMemoryDataSource(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val popularMoviesCache: PopularMoviesCache,
    private val movieDetailCache: MovieDetailCache
) : MovieLocalDataSource {


    override suspend fun getMovieDetail(movieId: Long): MovieDetail? {
        return movieDetailCache.getMoviesDetail(movieId) {
            movieRemoteDataSource.getMovieDetail(movieId)
        }
    }

    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return popularMoviesCache.getPopularMovies(page) {
            movieRemoteDataSource.getPopularMovies(page)
        }
    }
}