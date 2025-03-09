package com.bill_d00r.gifsviewer.domain

data class Gif(
    val hash: String,
    val imagePath: String,
    val previewImagePath: String,
    val id: Int,
    val title: String?,
    val remoteId: String,
)
