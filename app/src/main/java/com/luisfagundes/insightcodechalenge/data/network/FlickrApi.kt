package com.luisfagundes.insightcodechalenge.data.network

import com.luisfagundes.insightcodechalenge.data.response.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    suspend fun searchPhotos(
        @Query("tags") tags: String
    ): FlickrResponse
}