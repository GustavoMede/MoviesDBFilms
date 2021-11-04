package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse

interface MovieRepository {

    suspend fun getMovies(): MovieResponse?
}