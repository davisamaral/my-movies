package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.movie.data.api.MovieApiService
import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase
import com.davisamaral.mymovies.movie.domain.model.Movie
import retrofit2.await

internal class MovieApiDataSource(
    private val movieApiService: MovieApiService,
    private val getAppConfigurationUseCase: GetAppConfigurationUseCase,
) : MovieRemoteDataSource {

    private val apiKey by lazy {
        getAppConfigurationUseCase().theMovieDbConfiguration.apiKey
    }

    override suspend fun getMovies(): List<Movie> {
        val movieCall = movieApiService.getPopularMovies(apiKey)
        return movieCall?.await()?.results.orEmpty().map {
            Movie(
                id = it.id,
                title = it.title,
                releaseDate = it.releaseDate,
                originalTitle = it.originalTitle,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                isAdult = it.isAdult,
                genreIds = it.genreIds,
                originalLanguage = it.originalLanguage,
                overview = it.overview,
                popularity = it.popularity,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
            )
        }
    }
}