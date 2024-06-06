package com.luisfagundes.insightcodechalenge.data.mapper

import com.luisfagundes.insightcodechalenge.data.response.FlickrItem
import com.luisfagundes.insightcodechalenge.data.response.FlickrResponse
import com.luisfagundes.insightcodechalenge.domain.model.Flickr

object FlickerMapper {
    fun FlickrResponse.mapToDomain() = items.map { it.mapToDomain() }

    private fun FlickrItem.mapToDomain() = Flickr(
        title = this.title,
        mediaUrl = this.media.m,
        description = this.description,
        published = this.published,
        author = this.author
    )
}