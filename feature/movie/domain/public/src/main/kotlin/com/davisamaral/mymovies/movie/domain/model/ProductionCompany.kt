package com.davisamaral.mymovies.movie.domain.model

data class ProductionCompany(
    val id: Long,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)