package com.davisamaral.mymovies.splash.navigation.impl.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import com.davisamaral.mymovies.splash.screen.SplashScreen
import com.davisamaral.mymovies.utility.navigation.NavigationConfiguration
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
internal class SplashNavigationConfiguration(
    private val splashNavigator: SplashNavigator,
    private val topBarManager: TopBarManager,
) : NavigationConfiguration {

    override val route: String = "splash"

    override fun configureNavigation(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    ) {
        navGraphBuilder.navigation(startDestination = "splashScreen", route = route) {
            composable(route = "splashScreen") {
                topBarManager.setPageTitle("Splash")
                SplashScreen(
                    splashNavigator = splashNavigator,
                    navController = navController,
                )
            }
        }
    }
}

