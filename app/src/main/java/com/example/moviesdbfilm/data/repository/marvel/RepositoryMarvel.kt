package com.example.moviesdbfilm.data.repository.marvel

import com.example.moviesdbfilm.data.repository.URL_BASE_MARVEL
import com.example.moviesdbfilm.data.repository.moviesdb.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RepositoryMarvel {
    fun getData(): ApiServiceMarvel {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(URL_BASE_MARVEL)
            .build()
            .create(ApiServiceMarvel::class.java)
    }
}