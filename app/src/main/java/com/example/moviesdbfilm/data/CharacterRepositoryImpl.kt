package com.example.moviesdbfilm.data

import com.example.moviesdbfilm.data.repository.marvel.MarvelDataSource
import com.example.moviesdbfilm.data.repository.model.marvel.Characters

class CharacterRepositoryImpl(
    private val marvelDataSourceImpl: MarvelDataSource
): CharacterRepository {

    override suspend fun getChars(): Characters? {
        return marvelDataSourceImpl.getChars()
    }
}