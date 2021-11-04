package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.model.marvel.Characters

interface CharacterRepository {

    suspend fun getChars(): Characters?
}