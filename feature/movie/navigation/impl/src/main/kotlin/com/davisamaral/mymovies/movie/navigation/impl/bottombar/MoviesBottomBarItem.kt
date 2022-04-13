package com.davisamaral.mymovies.movie.navigation.impl.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.davisamaral.mymovies.utility.navigation.BottomBarItem

class MoviesBottomBarItem : BottomBarItem {
    override val isStartScreen = false
    override val priority = 20
    override val route: String = "movie"
    override val title: String = "MOVIES"
    override val icon: ImageVector = Icons.Filled.Person
}