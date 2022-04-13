package com.davisamaral.mymovies.movie.domain.usecase

import com.davisamaral.mymovies.movie.domain.model.MovieDetail

interface GetMovieDetailUseCase {
    suspend operator fun invoke(movieId: Long): MovieDetail?
}