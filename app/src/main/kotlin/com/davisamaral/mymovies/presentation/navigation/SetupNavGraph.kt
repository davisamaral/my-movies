package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.davisamaral.mymovies.movie.navigation.MovieNavigator
import com.davisamaral.mymovies.presentation.splash.SplashScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    movieNavigator: MovieNavigator,
) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        movieNavigator.configureNavigation(
            navGraphBuilder = this,
            navController = navController
        )
    }
}
