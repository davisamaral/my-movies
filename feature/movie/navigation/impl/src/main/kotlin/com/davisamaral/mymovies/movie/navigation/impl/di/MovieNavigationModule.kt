package com.davisamaral.mymovies.movie.navigation.impl.di

import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.navigation.impl.bottombar.MoviesBottomBarItem
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieDetailScreenDefinition
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieListScreenDefinition
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieNavigationDefinition
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieNavigatorImpl
import com.davisamaral.mymovies.utility.kotlin.extensions.intoMultibinding
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import org.koin.dsl.module

val movieNavigationModule = module {

    single<MovieNavigator> { MovieNavigatorImpl(get()) }
    factory { MovieDetailScreenDefinition(get(), get()) }
    factory { MovieListScreenDefinition(get(), get(), get()) }

    intoMultibinding<NavigationDefinition> {
        MovieNavigationDefinition(get(), get())
    }

    intoMultibinding<BottomBarItem> { MoviesBottomBarItem() }
}