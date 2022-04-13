package com.davisamaral.mymovies.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.davisamaral.mymovies.utility.navigation.TopBarManager

@ExperimentalAnimationApi
@Composable
fun TopBar(
    navController: NavHostController,
    topBarManager: TopBarManager
) {
    TopAppBar(
        title = {
            Text(text = topBarManager.pageTitle.collectAsState().value)
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.Menu, "backIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        elevation = 10.dp
    )
}
