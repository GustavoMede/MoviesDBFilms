package com.example.moviesdbfilm.domain.usecase

import com.example.moviesdbfilm.data.CharacterRepository
import com.example.moviesdbfilm.data.repository.model.marvel.Result
import java.lang.Exception

class CharactersUseCaseImpl(
    private val repository: CharacterRepository
): CharactersUseCase {

    override suspend fun getChars(): List<Result> {
        repository.getChars()?.let {
            return it.data.results.onEach {
                it.thumbnail.path = it.thumbnail.path.replace("http", "https") + "." + it.thumbnail.extension
            }.toList()
        }
            throw Exception("Impossible to get list the list of characters.")
    }
}
