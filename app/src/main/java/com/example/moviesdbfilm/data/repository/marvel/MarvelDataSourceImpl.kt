package com.example.moviesdbfilm.data.repository.marvel

import android.util.Log
import com.example.moviesdbfilm.data.repository.*
import com.example.moviesdbfilm.data.repository.model.marvel.Characters
import com.example.moviesdbfilm.support.toMd5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelDataSourceImpl : MarvelDataSource {

    override suspend fun getChars(): Characters? {
        try {
            val charactersResponse = withContext(Dispatchers.IO) {
                RepositoryMarvel.getData().getCharacters(TS, API_KEY_MARVEL, TOKEN.toMd5(), LIMIT)
            }
            if (charactersResponse != null) {
                return charactersResponse
            }
            return null
        } catch (e: Exception) {
            Log.e("MARVEL", e.message.toString())
            return null
        }
    }
}