package com.davisamaral.mymovies.movie.domain.impl.usecase

import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository
import com.davisamaral.mymovies.movie.domain.usecase.GetPopularMoviesUseCase

internal class GetPopularMovies(private val repository: MovieRepository) : GetPopularMoviesUseCase {
    override suspend fun invoke(page: Int): List<Movie> = repository.getPopularMovies(page)
}