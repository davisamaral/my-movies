package com.davisamaral.mymovies.splash.di

import com.davisamaral.mymovies.splash.navigation.impl.di.splashNavigationModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


val featureSplashModule = module {

    val modules = listOf(
        splashNavigationModule,
        splashPresentationModule,
    )

    loadKoinModules(modules)
}
