package com.davisamaral.mymovies.configuration.usecase

import com.davisamaral.mymovies.configuration.model.AppConfiguration

interface GetAppConfigurationUseCase {
    operator fun invoke(): AppConfiguration
}