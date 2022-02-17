package com.davisamaral.mymovies.presentation.splash

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SplashViewModel : ViewModel() {

    val splashState: MovieState
    private val counterMutex = Mutex()

    init {
        splashState = MovieState()
        startCountDown()
    }

    @Stable
    class MovieState {
        val counter = mutableStateOf("")
        val isFinished = mutableStateOf(false)
    }

    private fun startCountDown() = viewModelScope.launch {
        counterMutex.withLock {
            if (!splashState.isFinished.value) {
                (0..4).sortedDescending().forEach {
                    splashState.counter.value = it.toString()
                    if (it > 0) delay(1000)
                }
                splashState.isFinished.value = true
            }
        }
    }
}