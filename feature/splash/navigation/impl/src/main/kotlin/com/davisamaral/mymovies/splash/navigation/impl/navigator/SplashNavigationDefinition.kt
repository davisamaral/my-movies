package com.davisamaral.mymovies.splash.navigation.impl.navigator

import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import com.davisamaral.mymovies.utility.navigation.ScreenDefinition

class SplashNavigationDefinition(
    splashScreenDefinition: SplashScreenDefinition,
) : NavigationDefinition {

    override val startDestination: String = splashScreenDefinition.route
    override val route: String = ROUTE

    override val screenDefinitions: List<ScreenDefinition> = listOf(splashScreenDefinition)

    companion object {
        private const val ROUTE = "splash"
    }
}