package com.luisfagundes.insightcodechalenge.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: FlickrDispatchers)

enum class FlickrDispatchers {
    Default,
    IO,
}