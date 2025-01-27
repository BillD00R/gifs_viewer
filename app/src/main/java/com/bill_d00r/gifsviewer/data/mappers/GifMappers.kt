package com.bill_d00r.gifsviewer.data.mappers

import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloader
import com.bill_d00r.gifsviewer.data.remote.dto.GiphyDto
import com.bill_d00r.gifsviewer.domain.Gif

suspend fun GiphyDto.toGifEntities(imageDownloader: GifImageDownloader, offset: Int): List<GifEntity> {
    var index = offset
    return data.map {
        val image = it.images.original
        val uri = imageDownloader.downloadGifImage(
            imageUrl = image.url,
            fileName = "${it.id}.gif"
        )

        GifEntity(
            id = ++index, //Autogenerating local ids
            title = it.title,
            hash = image.hash,
            height = image.height,
            size = image.size,
            imageUri = uri,
            width = image.width,
            remoteId = it.id
        )
    }
}

fun GifEntity.toGif(): Gif {
    return Gif(
        id = id,
        hash = hash,
        height = height,
        size = size,
        imageUri = imageUri,
        width = width,
        title = title,
    )
}


