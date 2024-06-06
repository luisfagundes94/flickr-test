package com.luisfagundes.insightcodechalenge.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.luisfagundes.insightcodechalenge.domain.model.Flickr

@Composable
fun FlickrGrid(
    items: List<Flickr>,
    columns: GridCells = GridCells.Adaptive(minSize = 128.dp),
    onItemClick: (String) -> Unit = {},
) {
    LazyVerticalGrid(
        columns = columns,
    ) {
        items(items) { flickr ->
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable { onItemClick(flickr.title) },

                model = flickr.mediaUrl,
                contentScale = ContentScale.Crop,
                contentDescription = flickr.description,
            )
        }
    }
}