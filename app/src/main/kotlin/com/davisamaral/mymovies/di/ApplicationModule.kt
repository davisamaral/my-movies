package com.davisamaral.mymovies.di

import com.davisamaral.mymovies.configuration.di.ConfigurationMainModule
import com.davisamaral.mymovies.movie.di.featureMovieModule
import com.davisamaral.mymovies.network.di.networkModule
import com.davisamaral.mymovies.presentation.navigation.AppNavigationManager
import com.davisamaral.mymovies.presentation.navigation.TopBarDefaultManager
import com.davisamaral.mymovies.presentation.navigation.TopBarViewModel
import com.davisamaral.mymovies.splash.di.featureSplashModule
import com.davisamaral.mymovies.utility.navigation.NavigationManager
import com.davisamaral.mymovies.utility.navigation.TopBarManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule = module {

    loadKoinModules(ConfigurationMainModule)
    loadKoinModules(networkModule)
    loadKoinModules(featureSplashModule)
    loadKoinModules(featureMovieModule)

    single<TopBarManager> { TopBarDefaultManager() }
    single<NavigationManager> { AppNavigationManager() }

    viewModel { TopBarViewModel() }
}
