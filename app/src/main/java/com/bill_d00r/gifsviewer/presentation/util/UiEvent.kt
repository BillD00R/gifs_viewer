package com.bill_d00r.gifsviewer.presentation.util

sealed class UiEvent {
    data object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
}
