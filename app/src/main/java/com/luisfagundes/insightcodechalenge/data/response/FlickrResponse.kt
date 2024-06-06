package com.luisfagundes.insightcodechalenge.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class FlickrResponse(
    val items: List<FlickrItem>
)

@Serializable
data class FlickrItem(
    @SerialName("title") val title: String,
    @SerialName("media") val media: Media,
    @SerialName("description") val description: String,
    @SerialName("author") val author: String,
    @SerialName("published") val published: String
)

@Serializable
data class Media(
    @SerialName("m") val m: String
)