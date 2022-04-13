package com.davisamaral.mymovies.splash.screen

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SplashViewModel(
    private val splashNavigator: SplashNavigator,
    private val navController: NavController
) : ViewModel() {

    val splashState: MovieState
    private val counterMutex = Mutex()

    init {
        splashState = MovieState()
        startCountDown()
    }

    @Stable
    class MovieState {
        val counter = mutableStateOf("")
    }

    private fun startCountDown() = viewModelScope.launch {
        counterMutex.withLock {
            (0..2).sortedDescending().forEach {
                splashState.counter.value = it.toString()
                if (it > 0) delay(1000)
            }
            splashNavigator.navigateToHomeScreen(navController = navController)
        }
    }
}