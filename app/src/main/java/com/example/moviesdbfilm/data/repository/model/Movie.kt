package com.example.moviesdbfilm.data.repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val backdrop_path: String,
    var poster_path: String,
    val original_title: String,
    val overview: String,
    val vote_average: Double
): Parcelable
