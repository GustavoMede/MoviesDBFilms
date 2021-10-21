package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.MovieResponse

interface MovieRepository {

    suspend fun getMovies(): MovieResponse?
}