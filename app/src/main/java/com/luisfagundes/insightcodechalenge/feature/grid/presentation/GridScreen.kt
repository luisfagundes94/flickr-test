package com.luisfagundes.insightcodechalenge.feature.grid.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.luisfagundes.insightcodechalenge.R
import com.luisfagundes.insightcodechalenge.designsystem.components.FlickError
import com.luisfagundes.insightcodechalenge.designsystem.components.FlickrGrid
import com.luisfagundes.insightcodechalenge.designsystem.components.FlickrSearchBar

@Composable
fun GridRoute(
    viewModel: GridViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    GridScreen(
        modifier = Modifier.fillMaxSize(),
        uiState = uiState,
        onItemClick = onItemClick,
        onSearchPhotos = viewModel::searchPhotos
    )
}

@Composable
fun GridScreen(
    modifier: Modifier = Modifier,
    uiState: GridUiState,
    onItemClick: (String) -> Unit,
    onSearchPhotos: (String) -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FlickrSearchBar(
            modifier = Modifier.padding(16.dp),
            query = query,
            placeholderHint = stringResource(R.string.search_photos),
            onQueryChange = {
                query = it
                onSearchPhotos(it)
            },
            onSearch = onSearchPhotos
        )
        when (uiState) {
            is GridUiState.Empty -> {}
            is GridUiState.Loading -> CircularProgressIndicator()
            is GridUiState.Error -> FlickError(
                onClick = { onSearchPhotos(query) }
            )

            is GridUiState.Success -> FlickrGrid(
                items = uiState.data
            )
        }
    }
}

