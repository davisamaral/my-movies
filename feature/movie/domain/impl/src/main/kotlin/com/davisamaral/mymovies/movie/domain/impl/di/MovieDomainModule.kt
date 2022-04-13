package com.davisamaral.mymovies.movie.domain.impl.di

import com.davisamaral.mymovies.movie.domain.impl.usecase.GetMovieDetail
import com.davisamaral.mymovies.movie.domain.impl.usecase.GetPopularMovies
import com.davisamaral.mymovies.movie.domain.usecase.GetMovieDetailUseCase
import com.davisamaral.mymovies.movie.domain.usecase.GetPopularMoviesUseCase
import org.koin.dsl.module

val movieDomainModule = module {
    factory<GetPopularMoviesUseCase> { GetPopularMovies(get()) }
    factory<GetMovieDetailUseCase> { GetMovieDetail(get()) }
}