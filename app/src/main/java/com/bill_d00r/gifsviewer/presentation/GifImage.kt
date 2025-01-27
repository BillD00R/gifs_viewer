package com.bill_d00r.gifsviewer.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder

@Composable
fun CoilGifImage(url: String, modifier: Modifier) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    ImageComponent(
        imageUrl = url,
        imageLoader = imageLoader,
        contentDescription = "GIF for testing",
        modifier = modifier,
    )
}

@Composable
fun ImageComponent(
    imageUrl: String,
    imageLoader: ImageLoader,
    contentDescription: String,
    modifier: Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl, imageLoader = imageLoader),
        contentDescription = contentDescription,
        modifier = modifier
    )
}