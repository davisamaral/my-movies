package com.davisamaral.mymovies.configuration.impl.usecase

import android.content.Context
import com.davisamaral.mymovies.configuration.impl.R
import com.davisamaral.mymovies.configuration.model.AppConfiguration
import com.davisamaral.mymovies.configuration.model.AppConfiguration.CacheConfiguration
import com.davisamaral.mymovies.configuration.model.AppConfiguration.TheMovieDbConfiguration
import com.davisamaral.mymovies.configuration.usecase.GetAppConfigurationUseCase

internal class GetAppConfiguration(
    private val context: Context
) : GetAppConfigurationUseCase {

    override fun invoke(): AppConfiguration = with(context.resources) {
        AppConfiguration(
            theMovieDbConfiguration = TheMovieDbConfiguration(
                apiKey = getString(R.string.tmdb_api_key),
                baseUrl = getString(R.string.tmdb_base_url)
            ),
            cacheConfiguration = CacheConfiguration(
                movieListCacheDurationInSeconds = getInteger(R.integer.movie_list_cache_duration_in_seconds)
            )
        )
    }
}