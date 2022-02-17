package com.davisamaral.mymovies.movie.data.di

import com.davisamaral.mymovies.movie.data.datasource.MovieApiDataSource
import com.davisamaral.mymovies.movie.data.datasource.MovieLocalDataSource
import com.davisamaral.mymovies.movie.data.datasource.MovieMemoryDataSource
import com.davisamaral.mymovies.movie.data.datasource.MovieRemoteDataSource
import com.davisamaral.mymovies.movie.data.api.MovieApiService
import com.davisamaral.mymovies.movie.data.repository.DefaultMovieRepository
import com.davisamaral.mymovies.movie.domain.repository.MovieRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val movieDataModule = module {
    single<MovieRepository> { DefaultMovieRepository(get(), get()) }
    single<MovieLocalDataSource> { MovieMemoryDataSource(get()) }
    single<MovieRemoteDataSource> { MovieApiDataSource(get(), get()) }
    single<MovieApiService> {
        get<Retrofit>().create(MovieApiService::class.java)
    }
}