package com.davisamaral.mymovies.utility.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavigationConfiguration {

    val route: String

    fun configureNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
    )
}
