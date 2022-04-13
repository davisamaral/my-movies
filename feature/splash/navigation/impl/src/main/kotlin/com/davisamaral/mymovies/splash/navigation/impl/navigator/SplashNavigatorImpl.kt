package com.davisamaral.mymovies.splash.navigation.impl.navigator

import androidx.navigation.NavController
import com.davisamaral.mymovies.splash.navigation.SplashNavigator

internal class SplashNavigatorImpl : SplashNavigator {

    override fun navigateToHomeScreen(navController: NavController) {
        navController.navigate("movie") {
            popUpTo("splash") { inclusive = true }
        }
    }
}