package com.davisamaral.mymovies.utility.navigation

interface NavigationCommand {
    val destination: String
    val popUpTo: String?
    val popUpInclusive: Boolean
}