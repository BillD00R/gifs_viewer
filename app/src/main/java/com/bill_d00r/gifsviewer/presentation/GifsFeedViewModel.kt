package com.bill_d00r.gifsviewer.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.mappers.toGif
import com.bill_d00r.gifsviewer.presentation.util.Routes
import com.bill_d00r.gifsviewer.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifsFeedViewModel @Inject constructor(
    pager: Pager<Int, GifEntity>
): ViewModel() {

    val gifsPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toGif() }
        }
        .cachedIn(viewModelScope)

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: GifsFeedEvent) {
        when(event) {
            is GifsFeedEvent.OnGifClick -> {
                Log.d("GIF_SELECTED_EVENT", "Gif ID: ${event.gif.id}")
                sendUiEvent(UiEvent.Navigate(Routes.GIFS_CAROUSEL + "?gifId=${event.gif.id}"))
            }

            is GifsFeedEvent.OnDeleteGif -> TODO()
            GifsFeedEvent.OnUndoDeleteClick -> TODO()
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}