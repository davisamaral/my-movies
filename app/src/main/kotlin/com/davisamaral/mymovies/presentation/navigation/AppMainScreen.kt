package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@Composable
fun AppMainScreen(
    navController: NavHostController,
    navigationDefinitions: Set<NavigationDefinition>,
    bottomBarItems: Set<BottomBarItem>,
    topBarManager: TopBarManager,
) {
    NavigationScreen(
        navController = navController,
        bottomBarItems = bottomBarItems.sorted,
        topBarManager = topBarManager,
    ) { contentPadding ->

        AnimatedNavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController,
            startDestination = bottomBarItems.startDestination,
            enterTransition = { slideInHorizontally { fullWidth -> fullWidth } },
            exitTransition = { slideOutHorizontally { fullWidth -> -fullWidth } },
            popEnterTransition = { slideInHorizontally { fullWidth -> -fullWidth } },
            popExitTransition = { slideOutHorizontally { fullWidth -> fullWidth } }
        ) {
            navigationDefinitions.forEach { configuration ->
                navigation(
                    startDestination = configuration.startDestination,
                    route = configuration.route
                ) {
                    configuration.screenDefinitions.forEach { screen ->
                        screen.configureNavigation(this)
                    }
                }
            }
        }
    }
}

private val Set<BottomBarItem>.sorted: Set<BottomBarItem>
    get() = sortedByDescending { it.priority }.toSet()

private val Set<BottomBarItem>.startDestination: String
    get() = firstOrNull { it.isStartScreen }?.route ?: first().route