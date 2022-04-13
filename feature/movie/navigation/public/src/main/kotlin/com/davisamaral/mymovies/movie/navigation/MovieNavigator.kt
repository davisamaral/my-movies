package com.davisamaral.mymovies.movie.navigation

import androidx.navigation.NavController

interface MovieNavigator {

    fun navigateToMovieListScreen(navController: NavController)

    fun navigateToMovieDetailScreen(
        movieId: Long,
        navController: NavController
    )
}