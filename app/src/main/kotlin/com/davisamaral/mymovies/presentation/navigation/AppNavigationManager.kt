package com.davisamaral.mymovies.presentation.navigation

import com.davisamaral.mymovies.utility.navigation.NavigationCommand
import com.davisamaral.mymovies.utility.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppNavigationManager : NavigationManager {

    private val commands: MutableStateFlow<NavigationCommand?> = MutableStateFlow(null)
    override val navigationCommands: StateFlow<NavigationCommand?> = commands

    override fun navigate(command: NavigationCommand) {
        commands.value = command
    }
}