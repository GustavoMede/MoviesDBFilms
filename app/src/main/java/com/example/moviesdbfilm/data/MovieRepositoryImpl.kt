package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import com.example.moviesdbfilm.data.repository.moviesdb.MoviesDBDataSource

class MovieRepositoryImpl(
    private val moviesDataSource: MoviesDBDataSource
): MovieRepository {

    override suspend fun getMovies(): MovieResponse? = moviesDataSource.getMovies()
}