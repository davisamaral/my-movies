package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.davisamaral.mymovies.utility.navigation.BottomBarItem

@ExperimentalAnimationApi
@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarItems: Set<BottomBarItem>,
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination
    val route = navBackStackEntry.value?.destination?.route
    if (route !in listOf("splash", "splashScreen")) {
        BottomNavigation {
            bottomBarItems.forEach { bottomBarItem ->
                BottomNavigationItem(
                    icon = { Icon(bottomBarItem.icon, contentDescription = null) },
                    label = { Text(bottomBarItem.title) },
                    selected = currentDestination?.hierarchy?.any { it.route == bottomBarItem.route } == true,
                    onClick = {
                        navController.navigate(bottomBarItem.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
