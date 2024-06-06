package com.luisfagundes.insightcodechalenge.feature.details.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsRoute(
    onBackPressed: () -> Unit
) {
    DetailsScreen(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed
    )
}

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {

}

