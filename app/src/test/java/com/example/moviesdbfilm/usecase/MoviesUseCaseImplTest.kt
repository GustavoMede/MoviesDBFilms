package com.example.moviesdbfilm.usecase

import com.example.moviesdbfilm.data.MovieRepository
import com.example.moviesdbfilm.data.repository.model.moviesdb.Movie
import com.example.moviesdbfilm.data.repository.model.moviesdb.MovieResponse
import com.example.moviesdbfilm.domain.models.DataMovie
import com.example.moviesdbfilm.domain.usecase.MoviesUseCaseImpl
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.AfterEach

@ExperimentalCoroutinesApi
class MoviesUseCaseImplTest {

    private val repository = mockk<MovieRepository>()
    private val useCase = MoviesUseCaseImpl(repository)

    @AfterEach
    fun tearDown(){
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when successfully run getMovies, should return DataMovie`() = runBlockingTest {
        val listRepository = MovieResponse(1, listOf(Movie("backUrl", "posterUrl",
            "title", "overview", "1.0")), 1, 1)

        val expected = DataMovie().apply {
            this.results = mutableListOf(Movie("https://image.tmdb.org/t/p/originalbackUrl",
                "https://image.tmdb.org/t/p/originalposterUrl",
                "title", "overview", "1.0"))
        }

        coEvery { repository.getMovies() } returns listRepository

        val result = useCase.getMovies()

        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(expected).isEqualTo(result)
    }

    @Test
    fun `when error in getMovies, should return Exception`() = runBlockingTest {
        val expected = Exception("That's an error!")

        coEvery { repository.getMovies() } throws expected

        var result: Exception? = null
        try{
            useCase.getMovies()
        }catch(e: Exception){
            result = e
        }

        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(result).isEqualTo(expected)
    }
}