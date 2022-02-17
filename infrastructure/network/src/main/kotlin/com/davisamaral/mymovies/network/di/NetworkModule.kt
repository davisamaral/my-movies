package com.davisamaral.mymovies.network.di

import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single<Retrofit> {
        val baseUrl = get<GetAppConfigurationUseCase>().invoke().theMovieDbConfiguration.baseUrl
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}
