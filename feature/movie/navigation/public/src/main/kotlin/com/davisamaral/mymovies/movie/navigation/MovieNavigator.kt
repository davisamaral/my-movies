package com.davisamaral.mymovies.movie.navigation

import com.davisamaral.mymovies.utility.navigation.Navigator

interface MovieNavigator : Navigator {

    fun navigateToMovieListScreen()

    fun navigateToMovieDetailScreen(movieId: Long)
}