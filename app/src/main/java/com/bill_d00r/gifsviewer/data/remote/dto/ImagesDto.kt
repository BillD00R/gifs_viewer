package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class ImagesDto(
    @Json(name = "original")
    val original: ImageDto = ImageDto(),

    @Json(name = "preview_gif")
    val previewGif: ImageDto = ImageDto(),

    )