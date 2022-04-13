package com.davisamaral.mymovies.utility.navigation

import androidx.compose.ui.graphics.vector.ImageVector

interface BottomBarItem {
    val isStartScreen: Boolean
    val priority: Int
    val route: String
    val title: String
    val icon: ImageVector
}
