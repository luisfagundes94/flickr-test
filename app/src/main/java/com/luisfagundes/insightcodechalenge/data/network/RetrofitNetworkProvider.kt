package com.luisfagundes.insightcodechalenge.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.luisfagundes.insightcodechalenge.BuildConfig
import com.luisfagundes.insightcodechalenge.data.datasource.NetworkDataSource
import com.luisfagundes.insightcodechalenge.data.response.FlickrResponse
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = BuildConfig.BACKEND_URL

@Singleton
class RetrofitNetworkProvider @Inject constructor(
    json: Json,
    okHttpCallFactory: dagger.Lazy<Call.Factory>,
) : NetworkDataSource {

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory { okHttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(FlickrApi::class.java)

    override suspend fun searchPhotos(tags: String) = api.searchPhotos(tags)
}