package com.davisamaral.mymovies.presentation.navigation

import com.davisamaral.mymovies.utility.navigation.TopBarManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopBarDefaultManager : TopBarManager {

    private val mutablePageTitleFlow = MutableStateFlow("Splash")
    override val pageTitle: StateFlow<String> = mutablePageTitleFlow.asStateFlow()

    override fun setPageTitle(title: String) {
        mutablePageTitleFlow.value = title
    }
}