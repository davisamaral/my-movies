package com.davisamaral.mymovies.movie.data.datasource

import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase
import com.davisamaral.mymovies.movie.data.api.MovieApiService
import com.davisamaral.mymovies.movie.domain.model.*
import retrofit2.await

internal class MovieApiDataSource(
    private val movieApiService: MovieApiService,
    private val getAppConfigurationUseCase: GetAppConfigurationUseCase,
) : MovieRemoteDataSource {

    private val apiKey by lazy {
        getAppConfigurationUseCase().theMovieDbConfiguration.apiKey
    }

    override suspend fun getMovieDetail(movieId: Long): MovieDetail? {
        val movieCall = movieApiService.getMovieDetail(
            apiKey = apiKey,
            movieId = movieId
        )
        return movieCall?.await()?.let {
            MovieDetail(
                id = it.id,
                title = it.title,
                isVideo = it.isVideo,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                isAdult = it.isAdult,
                budget = it.budget,
                genres = it.genres.map { genre ->
                    Genre(
                        id = genre.id,
                        name = genre.name,
                    )
                },
                homepage = it.homepage,
                imdbId = it.imdbId,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                productionCompanies = it.productionCompanies.map { produtionCompany ->
                    ProductionCompany(
                        id = produtionCompany.id,
                        logoPath = produtionCompany.logoPath,
                        name = produtionCompany.name,
                        originCountry = produtionCompany.originCountry
                    )

                },
                releaseDate = it.releaseDate,
                revenue = it.revenue,
                runtime = it.runtime,
                spokenLanguages = it.spokenLanguages.map { spokenLanguage ->
                    SpokenLanguage(
                        iso = spokenLanguage.iso,
                        name = spokenLanguage.name
                    )
                },
                status = it.status,
                tagline = it.tagline,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
            )
        }
    }

    override suspend fun getPopularMovies(page: Int): List<Movie> {
        val movieCall = movieApiService.getPopularMovies(apiKey, page)
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