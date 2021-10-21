package com.example.moviesdbfilm.domain.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesdbfilm.domain.usecase.MoviesUseCase
import com.example.moviesdbfilm.support.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Movies(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<Resource<DataMovie>>()

    val moviesLiveData: LiveData<Resource<DataMovie>> get() = _moviesLiveData

    fun getMovies() = viewModelScope.launch {
        try {
            val movies = withContext(Dispatchers.IO) {
                moviesUseCase.getMovies()
            }
            withContext(Dispatchers.Main) {
                _moviesLiveData.value = Resource.success(movies)
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main) {
                _moviesLiveData.value = Resource.error(e.message.toString())
            }
        }
    }
}