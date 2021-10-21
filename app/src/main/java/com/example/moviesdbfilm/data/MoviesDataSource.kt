package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.MovieResponse

interface MoviesDataSource {

    suspend fun getMovies(): MovieResponse?
}