package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.TopBarManager

@ExperimentalAnimationApi
@Composable
fun NavigationScreen(
    navController: NavHostController,
    bottomBarItems: Set<BottomBarItem>,
    topBarManager: TopBarManager,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { TopBar(navController = navController, topBarManager = topBarManager) },
        bottomBar = { BottomBar(navController = navController, bottomBarItems = bottomBarItems) },
        content = content
    )
}
