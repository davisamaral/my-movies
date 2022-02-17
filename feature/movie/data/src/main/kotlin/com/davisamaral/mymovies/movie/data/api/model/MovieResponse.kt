package com.davisamaral.mymovies.movie.data.api.model

import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "title")
    val title: String,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "adult")
    val isAdult: Boolean,
    @Json(name = "genre_ids")
    val genreIds: List<Long>?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Long
)