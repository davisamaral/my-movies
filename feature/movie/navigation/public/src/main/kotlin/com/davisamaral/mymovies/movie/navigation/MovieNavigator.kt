package com.davisamaral.mymovies.movie.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface MovieNavigator {

    fun configureNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    )

    fun navigateToMovieListScreen(navController: NavController)

    fun navigateToMovieDetailScreen(movieTitle: String, navController: NavController)
}