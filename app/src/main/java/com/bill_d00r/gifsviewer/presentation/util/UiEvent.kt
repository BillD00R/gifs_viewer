package com.bill_d00r.gifsviewer.presentation.util

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class Search(val prompt: String):UiEvent()
}
