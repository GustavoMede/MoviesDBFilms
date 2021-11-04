package com.example.moviesdbfilm.data.repository.moviesdb

import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/discover/movie?22")
    suspend fun getMovies(@Query("api_key") apiKey: String): MovieResponse

}