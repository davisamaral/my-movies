package com.davisamaral.mymovies.movie.presentation.list.di

import com.davisamaral.mymovies.movie.presentation.list.screen.PopularMoviesPagingSource
import org.koin.dsl.module

val moviePresentationModule = module {
    factory { PopularMoviesPagingSource(get()) }
}