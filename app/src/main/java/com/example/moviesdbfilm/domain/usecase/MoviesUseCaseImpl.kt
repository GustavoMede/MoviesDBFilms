package com.example.moviesdbfilm.domain.usecase

import com.example.moviesdbfilm.data.MovieRepository
import com.example.moviesdbfilm.data.repository.IMAGE_URL
import com.example.moviesdbfilm.domain.models.DataMovie

class MoviesUseCaseImpl(
    private val repository: MovieRepository
): MoviesUseCase {

    override suspend fun getMovies(): DataMovie {
        val moviesResponse = repository.getMovies()
        var movies = DataMovie()

        moviesResponse?.let {
            for(movie in moviesResponse.results){
                val posterUrl = movie.poster_path
                val backdropUrl = movie.backdrop_path
                movie.poster_path = IMAGE_URL + posterUrl
                movie.backdrop_path = IMAGE_URL + backdropUrl
                movies.results.add(movie)
            }
            return movies
        }
        return movies
    }
}