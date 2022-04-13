package com.davisamaral.mymovies.movie.navigation.impl.navigator

import androidx.navigation.NavController
import com.davisamaral.mymovies.movie.navigation.MovieNavigator

internal class MovieNavigatorImpl : MovieNavigator {

    override fun navigateToMovieListScreen(navController: NavController) {
        navController.navigate("movieList")
    }

    override fun navigateToMovieDetailScreen(
        movieId: Long,
        navController: NavController
    ) {
        navController.navigate("movieDetail/$movieId")
    }
}

