package com.davisamaral.mymovies.movie.domain.impl.usecase

import com.davisamaral.mymovies.movie.domain.model.MovieDetail
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase

internal class GetMovieDetail(private val repository: MovieRepository) : GetMovieDetailUseCase {

    override suspend fun invoke(movieId: Long): MovieDetail? = repository.getMovieDetail(movieId)

}