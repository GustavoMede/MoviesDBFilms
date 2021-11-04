package com.example.moviesdbfilm.domain.usecase

import com.example.moviesdbfilm.data.repository.model.marvel.Result

interface CharactersUseCase {

    suspend fun getChars(): List<Result>
}