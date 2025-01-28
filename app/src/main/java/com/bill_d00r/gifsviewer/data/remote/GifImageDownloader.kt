package com.bill_d00r.gifsviewer.data.remote

interface GifImageDownloader {
    suspend fun downloadGifImage(imageUrl: String, fileName: String):String
    suspend fun clearImageCache()
}