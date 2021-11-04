package com.example.moviesdbfilm.data.repository.model.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Thumbnail(var path: String,
                val extension: String): Parcelable
