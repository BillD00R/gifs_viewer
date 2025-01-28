package com.bill_d00r.gifsviewer.presentation

import com.bill_d00r.gifsviewer.domain.Gif

sealed class GifsFeedEvent {
    data class OnDeleteGif(val gif: Gif): GifsFeedEvent()
    object OnUndoDeleteClick: GifsFeedEvent()
    data class OnGifClick(val index: Int): GifsFeedEvent()
    data class OnSearchQueryChanged(val searchQuery: String): GifsFeedEvent()
    object OnSearch: GifsFeedEvent()
}