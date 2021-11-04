package com.example.moviesdbfilm.data.repository.moviesdb

import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse

interface MoviesDBDataSource {

    suspend fun getMovies(): MovieResponse?
}