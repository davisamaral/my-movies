package com.davisamaral.mymovies.utility.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder

interface ScreenDefinition {

    val route: String
    val arguments: List<NamedNavArgument>
    fun configureNavigation(navGraphBuilder: NavGraphBuilder)
}