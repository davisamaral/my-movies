package com.davisamaral.mymovies.splash.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.davisamaral.mymovies.splash.navigation.SplashNavigator

class SplashViewModelFactory(
    private val splashNavigator: SplashNavigator,
    private val navController: NavController
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SplashNavigator::class.java, NavController::class.java)
            .newInstance(splashNavigator, navController)
    }
}