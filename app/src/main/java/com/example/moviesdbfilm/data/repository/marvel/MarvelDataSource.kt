package com.example.moviesdbfilm.data.repository.marvel

import com.example.moviesdbfilm.data.repository.model.marvel.Characters

interface MarvelDataSource {

    suspend fun getChars(): Characters?
}