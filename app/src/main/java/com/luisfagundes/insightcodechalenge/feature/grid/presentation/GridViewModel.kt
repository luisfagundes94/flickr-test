package com.luisfagundes.insightcodechalenge.feature.grid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisfagundes.insightcodechalenge.core.di.Dispatcher
import com.luisfagundes.insightcodechalenge.core.network.Result
import com.luisfagundes.insightcodechalenge.core.di.FlickrDispatchers.IO
import com.luisfagundes.insightcodechalenge.domain.repository.FlickrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor(
    private val repository: FlickrRepository,
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _uiState = MutableStateFlow<GridUiState>(GridUiState.Empty)
    val uiState = _uiState.asStateFlow()

    fun searchPhotos(tags: String) = viewModelScope.launch(dispatcher) {
        _uiState.value = GridUiState.Loading
        _uiState.value = when (val result = repository.searchPhotos(tags)) {
            is Result.Success -> GridUiState.Success(result.data)
            is Result.Error -> GridUiState.Error
        }
    }
}