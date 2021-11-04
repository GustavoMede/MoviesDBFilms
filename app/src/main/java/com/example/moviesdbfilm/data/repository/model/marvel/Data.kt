package com.example.moviesdbfilm.data.repository.model.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data(
    val results: MutableList<Result>
): Parcelable
