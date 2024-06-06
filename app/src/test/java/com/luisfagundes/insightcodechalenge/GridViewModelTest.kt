package com.luisfagundes.insightcodechalenge

import com.luisfagundes.insightcodechalenge.domain.repository.FlickrRepository
import com.luisfagundes.insightcodechalenge.feature.grid.presentation.GridUiState
import com.luisfagundes.insightcodechalenge.feature.grid.presentation.GridViewModel
import com.luisfagundes.insightcodechalenge.core.network.Result
import com.luisfagundes.insightcodechalenge.utils.FakeFlickrFactory
import io.mockk.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GridViewModelTest {

    private val repository = mockk<FlickrRepository>()
    private val dispatcher: CoroutineDispatcher = UnconfinedTestDispatcher()

    private lateinit var viewModel: GridViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = GridViewModel(repository, dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is Empty`() {
        assertEquals(GridUiState.Empty, viewModel.uiState.value)
    }

    @Test
    fun `searchPhotos results in Loading state`() = runTest {
        val data = FakeFlickrFactory.flickers

        coEvery { repository.searchPhotos("forest") } coAnswers {
            delay(1000)
            Result.Success(data)
        }

        val states = mutableListOf<GridUiState>()
        val job = launch {
            viewModel.uiState.collect { state ->
                states.add(state)
            }
        }

        viewModel.searchPhotos("forest")
        advanceTimeBy(500)

        assertEquals(GridUiState.Loading, viewModel.uiState.value)

        job.cancel()
    }

    @Test
    fun `searchPhotos results in Success when repository returns success`() = runTest {
        val data = FakeFlickrFactory.flickers

        coEvery { repository.searchPhotos("forest") } returns Result.Success(data)

        viewModel.searchPhotos("forest")
        advanceUntilIdle()

        assertEquals(GridUiState.Success(data), viewModel.uiState.value)
    }

    @Test
    fun `searchPhotos results in Error when repository returns error`() = runTest {
        coEvery { repository.searchPhotos("forest") } returns Result.Error(Exception("Error"))

        viewModel.searchPhotos("forest")
        advanceUntilIdle()

        assertEquals(GridUiState.Error, viewModel.uiState.value)
    }
}