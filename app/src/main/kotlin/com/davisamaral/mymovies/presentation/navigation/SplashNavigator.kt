package com.davisamaral.mymovies.presentation.navigation

import androidx.navigation.NavController

class SplashNavigator(private val navController: NavController) {

    fun navigateToHomeScreen() {
        navController.navigate("movies") {
            popUpTo("splash") { inclusive = true }
        }
    }
}