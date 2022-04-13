package com.davisamaral.mymovies.movie.di

import com.davisamaral.mymovies.movie.data.di.movieDataModule
import com.davisamaral.mymovies.movie.domain.impl.di.movieDomainModule
import com.davisamaral.mymovies.movie.navigation.impl.di.movieNavigationModule
import com.davisamaral.mymovies.movie.presentation.list.di.moviePresentationModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val featureMovieModule = module {

    val modules = listOf(
        movieDataModule,
        movieDomainModule,
        movieNavigationModule,
        moviePresentationModule
    )

    loadKoinModules(modules)
}
