package com.davisamaral.mymovies.di

import com.davisamaral.mymovies.configuration.di.ConfigurationMainModule
import com.davisamaral.mymovies.movie.di.movieModule
import com.davisamaral.mymovies.network.di.networkModule
import com.davisamaral.mymovies.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule = module {

    viewModel { SplashViewModel() }

    loadKoinModules(networkModule)
    loadKoinModules(ConfigurationMainModule)

    loadKoinModules(movieModule)
}
