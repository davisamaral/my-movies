package com.davisamaral.mymovies.splash.navigation.impl.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.davisamaral.mymovies.splash.navigation.SplashNavigator
import com.davisamaral.mymovies.splash.navigation.impl.bottombar.SplashBottomBarItem
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashNavigationConfiguration
import com.davisamaral.mymovies.splash.navigation.impl.navigator.SplashNavigatorImpl
import com.davisamaral.mymovies.utility.kotlin.extensions.intoMultibinding
import com.davisamaral.mymovies.utility.navigation.BottomBarItem
import com.davisamaral.mymovies.utility.navigation.NavigationConfiguration
import org.koin.dsl.module

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalAnimationApi::class)
val splashNavigationModule = module {
    single<SplashNavigator> { SplashNavigatorImpl() }

    intoMultibinding<NavigationConfiguration> {
        SplashNavigationConfiguration(get(), get())
    }

    intoMultibinding<BottomBarItem> { SplashBottomBarItem() }
}
