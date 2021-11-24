package com.example.moviesdbfilm.domain.models

import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie

data class DataMovie(var results: MutableList<Movie> = mutableListOf())