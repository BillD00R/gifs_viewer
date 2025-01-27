package com.bill_d00r.gifsviewer.presentation.feed

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.bill_d00r.gifsviewer.presentation.GifsFeedEvent
import com.bill_d00r.gifsviewer.presentation.GifsFeedViewModel
import com.bill_d00r.gifsviewer.presentation.util.UiEvent

@Composable
fun GifsFeedScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GifsFeedViewModel
) {
    val context = LocalContext.current
    val gifs = viewModel.gifsPagingFlow.collectAsLazyPagingItems()

    LaunchedEffect(key1 = gifs.loadState) {
        if (gifs.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (gifs.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }

        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        if (gifs.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(gifs) { gif ->
                    if (gif != null) {
                        GifItem(
                            gif = gif,
                            modifier = Modifier.fillMaxWidth(),
                            onItemClick = { it ->
                                Log.d("GIF_SELECTED", "Gif ID: ${it.id}")
                                viewModel.onEvent(GifsFeedEvent.OnGifClick(it))
                            }
                        )
                    }
                }
                item {
                    if (gifs.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }

}