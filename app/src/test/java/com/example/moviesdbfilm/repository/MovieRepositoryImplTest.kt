package com.example.moviesdbfilm.repository

import com.example.moviesdbfilm.data.MovieRepositoryImpl
import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import com.example.moviesdbfilm.data.repository.moviesdb.MoviesDBDataSource
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.AfterEach

@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {

    private val dataSource = mockk<MoviesDBDataSource>()
    private val repository = MovieRepositoryImpl(dataSource)

    @AfterEach
    fun tearDown(){
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when successfully run getMovies, should return MovieResponse`() = runBlockingTest {
        val expected = MovieResponse(1, listOf(mockk(), mockk()), 1, 1)

        coEvery { dataSource.getMovies() } returns expected

        val response = repository.getMovies()

        coVerify(exactly = 1) { dataSource.getMovies() }

        assertThat(response).isEqualTo(expected)
    }

    @Test
    fun `when error in getMovies, should throw Exception`() = runBlockingTest {
        val expected = Exception("That's an error!")

        coEvery { repository.getMovies() } throws expected

        var result: Exception? = null
        try {
            repository.getMovies()
        } catch (e: Exception){
            result = e
        }

        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(result).isEqualTo(expected)
    }
}
