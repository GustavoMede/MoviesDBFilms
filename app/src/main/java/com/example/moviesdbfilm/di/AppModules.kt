package com.example.moviesdbfilm.di

import com.example.moviesdbfilm.data.CharacterRepository
import com.example.moviesdbfilm.data.CharacterRepositoryImpl
import com.example.moviesdbfilm.data.repository.moviesdb.MoviesDBDataSourceImpl
import com.example.moviesdbfilm.data.MovieRepository
import com.example.moviesdbfilm.data.MovieRepositoryImpl
import com.example.moviesdbfilm.data.repository.marvel.MarvelDataSource
import com.example.moviesdbfilm.data.repository.marvel.MarvelDataSourceImpl
import com.example.moviesdbfilm.data.repository.moviesdb.MoviesDBDataSource
import com.example.moviesdbfilm.domain.usecase.CharactersUseCase
import com.example.moviesdbfilm.domain.usecase.CharactersUseCaseImpl
import com.example.moviesdbfilm.domain.usecase.MoviesUseCase
import com.example.moviesdbfilm.domain.usecase.MoviesUseCaseImpl
import com.example.moviesdbfilm.ui.fragments.home.MoviesViewModel
import com.example.moviesdbfilm.ui.fragments.marvel.MarvelCharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }

    factory<MoviesDBDataSource> {
        MoviesDBDataSourceImpl()
    }

    factory<MarvelDataSource> {
        MarvelDataSourceImpl()
    }

    factory<MoviesUseCase> {
        MoviesUseCaseImpl(get())
    }

    factory<CharactersUseCase> {
        CharactersUseCaseImpl(get())
    }

    viewModel { MoviesViewModel(get()) }
    viewModel { MarvelCharactersViewModel(get()) }
}