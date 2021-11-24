package com.example.moviesdbfilm.domain.usecase

import com.example.moviesdbfilm.data.MovieRepository
import com.example.moviesdbfilm.data.repository.IMAGE_URL
import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie
import com.example.moviesdbfilm.domain.models.DataMovie

class MoviesUseCaseImpl(
    private val repository: MovieRepository
): MoviesUseCase {

    override suspend fun getMovies(): DataMovie {

        val responseMapper: MutableList<Movie> = repository.getMovies()?.results?.map {
            it.posterPath = IMAGE_URL + it.posterPath
            it.backdropPath = IMAGE_URL + it.backdropPath
            it
        }?.toMutableList() ?: mutableListOf()

        return DataMovie().apply {
            this.results = responseMapper
        }
    }
}