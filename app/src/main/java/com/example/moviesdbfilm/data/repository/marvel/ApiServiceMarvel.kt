package com.example.moviesdbfilm.data.repository.marvel

import com.example.moviesdbfilm.data.repository.model.marvel.Characters
import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceMarvel {

    @GET("/v1/public/characters")
    suspend fun getCharacters(@Query("ts") ts: String,
                      @Query("apikey") apiKey: String,
                      @Query("hash") hash : String,
                      @Query("limit") limit: String): Characters

}