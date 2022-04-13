package com.davisamaral.mymovies.configuration.impl.di

import com.davisamaral.mymovies.configuration.impl.startup.DefaultAppStartupNotifier
import com.davisamaral.mymovies.configuration.impl.usecase.GetAppConfiguration
import com.davisamaral.mymovies.configuration.startup.AppStartupNotifier
import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase
import com.davisamaral.mymovies.utility.kotlin.extensions.getMultibinding
import org.koin.dsl.module

val configurationModule = module {
    factory<GetAppConfigurationUseCase> { GetAppConfiguration(get()) }
    single<AppStartupNotifier> { DefaultAppStartupNotifier(getKoin().getMultibinding()) }
}