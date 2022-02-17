package com.davisamaral.mymovies.configuration.model

data class AppConfiguration(
    val theMovieDbConfiguration: TheMovieDbConfiguration,
    val cacheConfiguration: CacheConfiguration
) {
    data class CacheConfiguration(
        val movieListCacheDurationInSeconds: Int
    )

    data class TheMovieDbConfiguration(
        val apiKey: String,
        val baseUrl: String,
    )
}
