package com.luisfagundes.insightcodechalenge.designsystem.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.luisfagundes.insightcodechalenge.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlickrSearchBar(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholderHint: String,
    onQueryChange: (String) -> Unit = {},
    onSearch: (String) -> Unit = {}
) {
    DockedSearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = onQueryChange,
        placeholder = { Text(placeholderHint) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search)
            )
        },
        onSearch = onSearch,
        active = false,
        onActiveChange = { }
    ) {

    }
}