package com.bill_d00r.gifsviewer.data.mappers

import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloader
import com.bill_d00r.gifsviewer.data.remote.dto.GiphyDto
import com.bill_d00r.gifsviewer.domain.Gif

suspend fun GiphyDto.toGifEntities(imageDownloader: GifImageDownloader, offset: Int): List<GifEntity> {
    var index = offset
    return data.map {
        val image = it.images.original
        
        val imagePath = imageDownloader.downloadGifImage(
            imageUrl = image.url,
            fileName = "${it.id}.gif"
        )
        val previewImagePath= imageDownloader.downloadGifImage(
            imageUrl = it.images.previewGif.url,
            fileName = "${it.id}(preview).gif"
        )
        GifEntity(
            id = ++index, //Autogenerating local ids
            title = it.title,
            hash = image.hash,
            height = image.height,
            size = image.size,
            imagePath = imagePath,
            previewImagePath = previewImagePath,
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
        imagePath = imagePath,
        previewImagePath = previewImagePath,
        width = width,
        title = title,
        remoteId = remoteId
    )
}


