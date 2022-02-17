package com.davisamaral.mymovies.configuration.impl.di

import com.davisamaral.mymovies.configuration.impl.usecase.GetAppConfiguration
import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase
import org.koin.dsl.module

val configurationModule = module {
    factory<GetAppConfigurationUseCase> { GetAppConfiguration(get()) }
}