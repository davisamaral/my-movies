package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationConfiguration
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@Composable
fun AppMainScreen(
    navController: NavHostController,
    navigationConfigurations: Set<NavigationConfiguration>,
    bottomBarItems: Set<BottomBarItem>,
    topBarManager: TopBarManager,
) {
    val rememberBottomBarItems =
        remember { bottomBarItems.sortedByDescending { it.priority }.toSet() }
    val rememberNavigationConfigurations = remember { navigationConfigurations }
    val startDestination = rememberBottomBarItems.firstOrNull { it.isStartScreen }?.route
        ?: rememberBottomBarItems.first().route

    NavigationScreen(
        navController = navController,
        bottomBarItems = rememberBottomBarItems,
        topBarManager = topBarManager,
    ) { contentPadding ->

        AnimatedNavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController,
            startDestination = startDestination,
            enterTransition = { slideInHorizontally { fullWidth -> fullWidth } },
            exitTransition = { slideOutHorizontally { fullWidth -> -fullWidth } },
            popEnterTransition = { slideInHorizontally { fullWidth -> -fullWidth } },
            popExitTransition = { slideOutHorizontally { fullWidth -> fullWidth } }
        ) {
            rememberNavigationConfigurations.forEach { configuration ->
                configuration.configureNavigation(
                    navGraphBuilder = this,
                    navController = navController
                )
            }
        }
    }
}