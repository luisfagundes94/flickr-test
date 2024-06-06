package com.luisfagundes.insightcodechalenge.data.datasource

import com.luisfagundes.insightcodechalenge.data.response.FlickrResponse

interface NetworkDataSource {
    suspend fun searchPhotos(tags: String): FlickrResponse
}