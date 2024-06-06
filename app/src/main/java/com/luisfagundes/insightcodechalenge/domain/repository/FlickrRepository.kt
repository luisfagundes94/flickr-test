package com.luisfagundes.insightcodechalenge.domain.repository

import com.luisfagundes.insightcodechalenge.core.network.Result
import com.luisfagundes.insightcodechalenge.domain.model.Flickr

interface FlickrRepository {
    suspend fun searchPhotos(query: String): Result<List<Flickr>>
}