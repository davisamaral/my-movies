package com.davisamaral.mymovies.movie.domain.model

data class Movie(
    val id: Long,
    val title: String,
    val releaseDate: String?,
    val originalTitle: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val isAdult: Boolean,
    val genreIds: List<Long>?,
    val originalLanguage: String?,
    val overview: String,
    val popularity: Double,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long
)
