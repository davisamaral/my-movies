package com.davisamaral.mymovies.splash.navigation.impl.navigator

import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashScreenDefinition.SplashScreenToHomeNavigationCommand
import com.davisamaral.mymovies.utility.navigation.NavigationManager

internal class SplashNavigatorImpl(
    override val navigationManager: NavigationManager,
) : SplashNavigator {

    override fun navigateToHomeScreen() {
        navigate(SplashScreenToHomeNavigationCommand())
    }
}