package com.bill_d00r.gifsviewer.data.remote

interface GifImageDownloader {
    suspend fun downloadGifImage(
        imageUrl: String,
        fileName: String,
    ): String

    // --Commented out by Inspection (17.02.2025 12:40):suspend fun clearImageCache()
    suspend fun deleteImages(paths: List<String>)
}
