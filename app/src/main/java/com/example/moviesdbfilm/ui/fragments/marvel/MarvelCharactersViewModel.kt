package com.example.moviesdbfilm.ui.fragments.marvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesdbfilm.data.repository.model.marvel.Result
import com.example.moviesdbfilm.domain.usecase.CharactersUseCase
import com.example.moviesdbfilm.support.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarvelCharactersViewModel(
    private val charactersUseCase: CharactersUseCase
) : ViewModel() {

    private val _charsLiveData = MutableLiveData<Resource<List<Result>>>()

    val charsLiveData: LiveData<Resource<List<Result>>> get() = _charsLiveData

    fun getChars() = viewModelScope.launch {
        try {
            val chars = withContext(Dispatchers.IO) {
                charactersUseCase.getChars()
            }
            withContext(Dispatchers.Main) {
                _charsLiveData.value = Resource.success(chars)
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main) {
                _charsLiveData.value = Resource.error(e.message.toString())
            }
        }
    }
}