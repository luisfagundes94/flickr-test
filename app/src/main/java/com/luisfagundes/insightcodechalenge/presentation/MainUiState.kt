package com.luisfagundes.insightcodechalenge.presentation

import com.luisfagundes.insightcodechalenge.domain.model.Flickr

sealed interface MainUiState {
    data object Loading : MainUiState
    data class Success(val data: List<Flickr>) : MainUiState
    data object Error : MainUiState
}