package com.bill_d00r.gifsviewer.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.bill_d00r.gifsviewer.data.mappers.toGif
import com.bill_d00r.gifsviewer.data.remote.repository.GiphyRepository
import com.bill_d00r.gifsviewer.domain.Gif
import com.bill_d00r.gifsviewer.presentation.util.Routes
import com.bill_d00r.gifsviewer.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GifsFeedViewModel @Inject constructor(
    private val repository: GiphyRepository
) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


    init {
        Log.d("VIEW_MODEL", "Initializing")
        getGifs()
    }

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: GifsFeedEvent) {
        when (event) {
            is GifsFeedEvent.OnGifClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.GIFS_CAROUSEL + "?index=${event.index}"))
            }

            is GifsFeedEvent.OnDeleteGif -> {
                deleteGif(event.gif)
            }

            is GifsFeedEvent.OnUndoDeleteClick -> TODO()
            is GifsFeedEvent.OnSearchQueryChanged -> {
                _state.value = _state.value.copy(searchQuery = event.searchQuery)
            }

            is GifsFeedEvent.OnSearch -> {
                getGifs()
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private fun getGifs() {
        val gifs = repository.getGifs(_state.value.searchQuery)
            .flow
            .map { pagingData ->
                pagingData.map { it.toGif() }
            }
            .cachedIn(viewModelScope)
        _state.value = _state.value.copy(gifsPagingFlow = gifs)
    }

    private fun deleteGif(gif: Gif) {
        repository.deleteGif(gif.remoteId)
    }
}

data class SearchState(
    val searchQuery: String = "",
    val gifsPagingFlow: Flow<PagingData<Gif>>? = null
)