package com.davisamaral.mymovies.movie.presentation.list.di

import com.davisamaral.mymovies.movie.presentation.list.screen.PopularMoviesPagingSource
import com.davisamaral.mymovies.utility.kotlin.extensions.intoMultibinding
import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import org.koin.dsl.module

val moviePresentationModule = module {
    factory { PopularMoviesPagingSource(get()) }
}