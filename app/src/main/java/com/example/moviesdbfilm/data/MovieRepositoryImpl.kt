package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.MovieResponse

class MovieRepositoryImpl(
    private val moviesDataSource: MoviesDataSource
): MovieRepository {

    override suspend fun getMovies(): MovieResponse? = moviesDataSource.getMovies()
}