package com.example.moviesdbfilm.data.repository.moviesdb

import com.example.moviesdbfilm.data.repository.API_KEY
import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MoviesDBDataSourceImpl: MoviesDBDataSource {

    override suspend fun getMovies(): MovieResponse? {
        try {
            val movieResponse = withContext(Dispatchers.IO){
                Repository.getData().getMovies(API_KEY)
            }
            if(movieResponse != null){
                return movieResponse
            }
            return null
        }catch (e: Exception){
            throw e
        }
    }

}