package com.davisamaral.mymovies.movie.navigation.impl.navigator

import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import com.davisamaral.mymovies.utility.navigation.ScreenDefinition

class MovieNavigationDefinition(
    movieListScreenDefinition: MovieListScreenDefinition,
    movieDetailScreenDefinition: MovieDetailScreenDefinition,
) : NavigationDefinition {

    override val startDestination: String = movieListScreenDefinition.route
    override val route: String = ROUTE

    override val screenDefinitions: List<ScreenDefinition> = listOf(
        movieListScreenDefinition,
        movieDetailScreenDefinition
    )

    companion object {
        private const val ROUTE = "movies"
    }
}