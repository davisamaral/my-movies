package com.davisamaral.mymovies.movie.di

import com.davisamaral.mymovies.movie.data.di.movieDataModule
import com.davisamaral.mymovies.movie.domain.impl.di.movieDomainModule
import com.davisamaral.mymovies.movie.navigation.impl.di.movieNavigationModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val movieModule = module {
    loadKoinModules(movieNavigationModule)
    loadKoinModules(movieDomainModule)
    loadKoinModules(movieDataModule)
}
