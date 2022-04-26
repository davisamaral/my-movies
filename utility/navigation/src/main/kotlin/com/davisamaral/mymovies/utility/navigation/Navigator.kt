package com.davisamaral.mymovies.utility.navigation

interface Navigator {
    val navigationManager: NavigationManager

    fun navigate(command: NavigationCommand) {
        navigationManager.navigate(command)
    }
}