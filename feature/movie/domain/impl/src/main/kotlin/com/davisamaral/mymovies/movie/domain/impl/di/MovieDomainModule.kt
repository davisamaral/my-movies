package com.davisamaral.mymovies.movie.domain.impl.di

import com.davisamaral.mymovies.movie.domain.impl.usecase.GetMovies
import com.davisamaral.mymovies.movie.domain.usecase.GetMoviesUseCase
import org.koin.dsl.module

val movieDomainModule = module {
    factory<GetMoviesUseCase> { GetMovies(get()) }
}