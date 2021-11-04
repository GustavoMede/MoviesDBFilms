package com.example.moviesdbfilm.data.repository.model.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Result(val id: Int,
             val name: String,
             val description: String,
             val thumbnail: Thumbnail
): Parcelable