package com.example.moviesdbfilm.domain.usecase

import com.example.moviesdbfilm.domain.models.DataMovie

interface MoviesUseCase {

    suspend fun getMovies(): DataMovie
}