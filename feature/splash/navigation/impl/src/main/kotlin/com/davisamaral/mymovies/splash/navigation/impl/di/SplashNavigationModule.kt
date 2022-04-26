package com.davisamaral.mymovies.splash.navigation.impl.di

import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import com.davisamaral.mymovies.splash.navigation.impl.bottombar.SplashBottomBarItem
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashNavigationDefinition
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashNavigatorImpl
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashScreenDefinition
import com.davisamaral.mymovies.utility.kotlin.extensions.intoMultibinding
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationDefinition
import org.koin.dsl.module

val splashNavigationModule = module {

    single<SplashNavigator> { SplashNavigatorImpl(get()) }
    factory { SplashScreenDefinition(get(), get()) }
    factory { SplashNavigationDefinition(get()) }

    intoMultibinding<NavigationDefinition> {
        SplashNavigationDefinition(get())
    }

    intoMultibinding<BottomBarItem> { SplashBottomBarItem() }
}
