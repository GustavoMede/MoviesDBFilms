package com.example.moviesdbfilm.data.repository.model.moviesdb

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @Json(name = "backdrop_path")
    var backdropPath: String,
    @Json(name = "poster_path")
    var posterPath: String,
    @Json(name = "original_title")
    val originalTitle: String,
    val overview: String,
    @Json(name = "vote_average")
    val voteAverage: String
): Parcelable
