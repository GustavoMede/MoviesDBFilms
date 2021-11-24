package com.example.moviesdbfilm.repository

import com.example.moviesdbfilm.data.CharacterRepositoryImpl
import com.example.moviesdbfilm.data.repository.marvel.MarvelDataSource
import com.example.moviesdbfilm.data.repository.model.marvel.Characters
import com.example.moviesdbfilm.data.repository.model.marvel.Data
import com.google.common.truth.Truth
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.AfterEach

@ExperimentalCoroutinesApi
class CharacterRepositoryImplTest {

    private val dataSource = mockk<MarvelDataSource>()
    private val repository = CharacterRepositoryImpl(dataSource)

    @AfterEach
    fun tearDown(){
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when successfully run getChars, should return Characters`() = runBlockingTest {
        val expected = Characters(Data(mutableListOf(mockk(), mockk())))

        coEvery { repository.getChars() } returns expected

        val response = repository.getChars()

        coVerify(exactly = 1) { repository.getChars() }

        Truth.assertThat(response).isEqualTo(expected)
    }

    @Test
    fun `when error in getChars, should throw Exception`() = runBlockingTest {
        val expected = Exception("That's an error!")

        coEvery { repository.getChars() } throws expected

        var result: Exception? = null
        try {
            repository.getChars()
        } catch (e: Exception){
            result = e
        }

        coVerify(exactly = 1) { repository.getChars() }

        Truth.assertThat(result).isEqualTo(expected)
    }
}