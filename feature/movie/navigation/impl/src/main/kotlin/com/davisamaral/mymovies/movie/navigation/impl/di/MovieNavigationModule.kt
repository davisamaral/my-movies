package com.davisamaral.mymovies.movie.navigation.impl.di

import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieNavigatorImpl
import org.koin.dsl.module

val movieNavigationModule = module {
    single<MovieNavigator> { MovieNavigatorImpl(get()) }
}