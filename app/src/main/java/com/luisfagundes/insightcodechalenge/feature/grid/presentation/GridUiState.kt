package com.luisfagundes.insightcodechalenge.feature.grid.presentation

import com.luisfagundes.insightcodechalenge.domain.model.Flickr

sealed interface GridUiState {
    data object Empty : GridUiState
    data object Loading : GridUiState
    data class Success(val data: List<Flickr>) : GridUiState
    data object Error : GridUiState
}