package com.davisamaral.mymovies.movie.navigation.impl.navigator

import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieDetailScreenDefinition.MovieDetailNavigationCommand
import com.davisamaral.mymovies.movie.navigation.impl.navigator.MovieListScreenDefinition.MovieListNavigationCommand
import com.davisamaral.mymovies.utility.navigation.NavigationManager

internal class MovieNavigatorImpl(
    override val navigationManager: NavigationManager,
) : MovieNavigator {

    override fun navigateToMovieListScreen() {
        navigate(MovieListNavigationCommand())
    }

    override fun navigateToMovieDetailScreen(movieId: Long) {
        navigate(MovieDetailNavigationCommand(movieId))
    }
}

