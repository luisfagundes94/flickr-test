package com.luisfagundes.insightcodechalenge.utils

import com.luisfagundes.insightcodechalenge.data.response.FlickrItem
import com.luisfagundes.insightcodechalenge.data.response.FlickrResponse
import com.luisfagundes.insightcodechalenge.data.response.Media
import com.luisfagundes.insightcodechalenge.domain.model.Flickr

object FakeFlickrFactory {
    val response =
        FlickrResponse(
            items = listOf(
                FlickrItem(
                    title = "Title 1",
                    media = Media(m = ""),
                    description = "",
                    author = "",
                    published = "",
                )
            )
        )
    val flickers = listOf(
        Flickr(
            title = "Title 1",
            mediaUrl = "",
            description = "",
            author = "",
            published = "",
        ),
        Flickr(
            title = "Title 2",
            mediaUrl = "",
            description = "",
            author = "",
            published = "",
        ),
    )
}