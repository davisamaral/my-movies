package com.davisamaral.mymovies.splash.navigation.impl.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector
import com.davisamaral.mymovies.utility.navigation.BottomBarItem

class SplashBottomBarItem : BottomBarItem {
    override val isStartScreen = true
    override val priority = 10
    override val route: String = "splash"
    override val title: String = "SPLASH"
    override val icon: ImageVector = Icons.Filled.Refresh
}