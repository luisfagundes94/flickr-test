package com.luisfagundes.insightcodechalenge.data.repository

import com.luisfagundes.insightcodechalenge.core.network.safeApiCall
import com.luisfagundes.insightcodechalenge.data.datasource.NetworkDataSource
import com.luisfagundes.insightcodechalenge.data.mapper.FlickerMapper.mapToDomain
import com.luisfagundes.insightcodechalenge.domain.repository.FlickrRepository
import javax.inject.Inject

class FlickrRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : FlickrRepository {
    override suspend fun searchPhotos(query: String) = safeApiCall {
        networkDataSource.searchPhotos(query).mapToDomain()
    }
}