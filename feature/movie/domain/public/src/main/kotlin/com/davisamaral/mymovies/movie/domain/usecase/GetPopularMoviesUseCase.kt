package com.davisamaral.mymovies.movie.domain.usecase

import com.davisamaral.mymovies.movie.domain.model.Movie

interface GetPopularMoviesUseCase {
    suspend operator fun invoke(page: Int = 0): List<Movie>
}