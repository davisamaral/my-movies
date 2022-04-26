package com.davisamaral.mymovies.utility.navigation

interface NavigationDefinition {
    val startDestination: String
    val route: String
    val screenDefinitions: List<ScreenDefinition>
}