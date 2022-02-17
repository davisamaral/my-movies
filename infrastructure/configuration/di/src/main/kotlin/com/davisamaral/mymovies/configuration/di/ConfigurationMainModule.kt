package com.davisamaral.mymovies.configuration.di

import com.davisamaral.mymovies.configuration.impl.di.configurationModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val ConfigurationMainModule = module {
    loadKoinModules(configurationModule)
}