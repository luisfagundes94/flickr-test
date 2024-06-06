package com.luisfagundes.insightcodechalenge.feature.details.presentation

import androidx.lifecycle.ViewModel
import com.luisfagundes.insightcodechalenge.core.di.Dispatcher
import com.luisfagundes.insightcodechalenge.core.di.FlickrDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    @Dispatcher(FlickrDispatchers.IO) private val dispatcher: CoroutineDispatcher
) : ViewModel() {

}