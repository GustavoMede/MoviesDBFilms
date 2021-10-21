package com.example.moviesdbfilm.di

import com.example.moviesdbfilm.data.MovieDBDataSource
import com.example.moviesdbfilm.data.MovieRepository
import com.example.moviesdbfilm.data.MovieRepositoryImpl
import com.example.moviesdbfilm.data.MoviesDataSource
import com.example.moviesdbfilm.domain.models.Movies
import com.example.moviesdbfilm.domain.usecase.MoviesUseCase
import com.example.moviesdbfilm.domain.usecase.MoviesUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    factory<MoviesDataSource> {
        //MovieRepository
        MovieDBDataSource(get())
    }

    factory<MoviesUseCase> {
        //MoviesDataSource
        MoviesUseCaseImpl(get())
    }

    viewModel<Movies> { Movies(get()) }
}