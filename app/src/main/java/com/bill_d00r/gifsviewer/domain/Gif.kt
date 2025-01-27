package com.bill_d00r.gifsviewer.domain


data class Gif(
    val hash: String,
    val height: String,
    val size: String,
    val imageUri: String,
    val width: String,
    val id: Int,
    val title: String?
)
