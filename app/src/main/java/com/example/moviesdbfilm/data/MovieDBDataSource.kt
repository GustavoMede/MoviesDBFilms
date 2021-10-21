package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieDBDataSource(
    private val repository: MovieRepository
): MoviesDataSource {

    override suspend fun getMovies(): MovieResponse? {
        try {
            val movieResponse = withContext(Dispatchers.IO){
                repository.getMovies()
            }
            if(movieResponse != null){
                return movieResponse
            }
            return null
        }catch (e: Exception){
            return null
        }
    }

}