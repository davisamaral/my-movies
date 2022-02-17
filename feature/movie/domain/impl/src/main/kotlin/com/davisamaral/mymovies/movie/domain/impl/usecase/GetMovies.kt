package com.davisamaral.mymovies.movie.domain.impl.usecase

import com.davisamaral.mymovies.movie.domain.model.Movie
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase

internal class GetMovies(private val repository: MovieRepository) : GetMoviesUseCase {
    override suspend fun invoke(): List<Movie> = repository.getMovies()
}