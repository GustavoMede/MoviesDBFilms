package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.API_KEY
import com.example.moviesdbfilm.data.repository.Repository
import com.example.moviesdbfilm.data.repository.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieDBDataSource: MoviesDataSource {

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
            return null
        }
    }

}