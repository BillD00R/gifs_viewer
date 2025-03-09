package com.bill_d00r.gifsviewer.presentation.feed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bill_d00r.gifsviewer.domain.Gif
import com.bill_d00r.gifsviewer.presentation.CoilGifImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GifItem(
    gif: Gif,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    onItemDelete: () -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        onClick = { onItemClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {

            CoilGifImage(
                url = gif.previewImagePath,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                    .padding(5.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
            ) {
                gif.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center)
                    )
                }
                IconButton(
                    onClick = { onItemDelete() },
                    modifier = Modifier.align(Alignment.BottomEnd),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}


