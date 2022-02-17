package com.davisamaral.mymovies.movie.domain.usecase

import com.davisamaral.mymovies.movie.domain.model.Movie

interface GetMoviesUseCase {
    suspend operator fun invoke(): List<Movie>
}