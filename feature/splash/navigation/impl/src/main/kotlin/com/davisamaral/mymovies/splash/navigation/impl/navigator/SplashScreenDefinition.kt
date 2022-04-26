package com.davisamaral.mymovies.splash.navigation.impl.navigator

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import com.davisamaral.mymovies.splash.screen.SplashScreen
import com.davisamaral.mymovies.utility.navigation.NavigationCommand
import com.davisamaral.mymovies.utility.navigation.ScreenDefinition
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.composable

class SplashScreenDefinition(
    private val splashNavigator: SplashNavigator,
    private val topBarManager: TopBarManager,
) : ScreenDefinition {

    override val route: String = SPLASH_ROUTE
    override val arguments: List<NamedNavArgument> = emptyList()

    @Suppress("OPT_IN_IS_NOT_ENABLED")
    @OptIn(ExperimentalAnimationApi::class)
    override fun configureNavigation(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            composable(
                route = this@SplashScreenDefinition.route,
                arguments = arguments,
                content = {
                    topBarManager.setPageTitle("Splash")
                    SplashScreen(splashNavigator = splashNavigator)
                }
            )
        }
    }

    class SplashScreenNavigationCommand : NavigationCommand {
        override val popUpInclusive: Boolean = true
        override val popUpTo: String = SPLASH_ROUTE
        override val destination: String = SPLASH_ROUTE
    }

    class SplashScreenToHomeNavigationCommand : NavigationCommand {
        override val popUpInclusive: Boolean = true
        override val popUpTo: String = SPLASH_ROUTE
        override val destination: String = HOME_ROUTE
    }

    companion object {
        private const val HOME_ROUTE = "movies"
        private const val SPLASH_ROUTE = "splashScreen"
    }
}