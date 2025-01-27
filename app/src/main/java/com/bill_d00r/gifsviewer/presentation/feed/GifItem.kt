package com.bill_d00r.gifsviewer.presentation.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bill_d00r.gifsviewer.domain.Gif
import com.bill_d00r.gifsviewer.presentation.CoilGifImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GifItem(
    gif: Gif,
    modifier: Modifier = Modifier,
    onItemClick: (Gif) -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        onClick = { onItemClick(gif) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {

            CoilGifImage(
                url = gif.imageUri,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                gif.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


