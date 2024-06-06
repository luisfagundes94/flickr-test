package com.luisfagundes.insightcodechalenge.data.di

import com.luisfagundes.insightcodechalenge.data.datasource.NetworkDataSource
import com.luisfagundes.insightcodechalenge.data.network.RetrofitNetworkProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindNetworkDataSource(
        retrofit: RetrofitNetworkProvider
    ): NetworkDataSource
}