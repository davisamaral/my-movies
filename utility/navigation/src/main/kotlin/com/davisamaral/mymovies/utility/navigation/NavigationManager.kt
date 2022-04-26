package com.davisamaral.mymovies.utility.navigation

import kotlinx.coroutines.flow.StateFlow

interface NavigationManager {
    val navigationCommands: StateFlow<NavigationCommand?>
    fun navigate(command: NavigationCommand)
}