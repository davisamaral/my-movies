package com.davisamaral.mymovies.utility.navigation

import kotlinx.coroutines.flow.StateFlow

interface TopBarManager {

    val pageTitle: StateFlow<String>
    fun setPageTitle(title: String)
}