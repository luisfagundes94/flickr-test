package com.luisfagundes.insightcodechalenge.data.di

import com.luisfagundes.insightcodechalenge.data.repository.FlickrRepositoryImpl
import com.luisfagundes.insightcodechalenge.domain.repository.FlickrRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    internal abstract fun bindFlickrRepository(
        repository: FlickrRepositoryImpl
    ): FlickrRepository
}