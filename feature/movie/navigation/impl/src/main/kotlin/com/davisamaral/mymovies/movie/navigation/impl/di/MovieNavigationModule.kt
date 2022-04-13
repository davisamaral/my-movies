package com.davisamaral.mymovies.movie.navigation.impl.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.navigation.impl.bottombar.MoviesBottomBarItem
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieNavigationConfiguration
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieNavigatorImpl
import com.davisamaral.mymovies.utility.kotlin.extensions.intoMultibinding
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationConfiguration
import org.koin.dsl.module

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalAnimationApi::class)
val movieNavigationModule = module {
    single<MovieNavigator> { MovieNavigatorImpl() }

    intoMultibinding<NavigationConfiguration> {
        MovieNavigationConfiguration(get(), get(), get(), get())
    }

    intoMultibinding<BottomBarItem> { MoviesBottomBarItem() }
}