package com.bill_d00r.gifsviewer.presentation.feed

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.bill_d00r.gifsviewer.presentation.GifsFeedEvent
import com.bill_d00r.gifsviewer.presentation.GifsFeedViewModel
import com.bill_d00r.gifsviewer.presentation.util.UiEvent

@Composable
fun GifsFeedScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GifsFeedViewModel
) {
    val context = LocalContext.current
    val state = viewModel.state.value

    LaunchedEffect(key1 = 1) {
//        if (gifs.loadState.refresh is LoadState.Error) {
//            Toast.makeText(
//                context,
//                "Error: " + (gifs.loadState.refresh as LoadState.Error).error.message,
//                Toast.LENGTH_LONG
//            ).show()
//        }

        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    Column {

        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(GifsFeedEvent.OnSearchQueryChanged(it))
            },
            placeholder = { Text("Search") },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {Icons.Rounded.Search},
            keyboardOptions = KeyboardOptions(
                autoCorrectEnabled = false,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { viewModel.onEvent(GifsFeedEvent.OnSearch) }),
            singleLine = true
        )
        state.gifsPagingFlow?.let { dataFlow ->
            val gifs = dataFlow.collectAsLazyPagingItems()
            Box(modifier = Modifier
                .fillMaxWidth().padding(10.dp)
                .weight(1f)) {
                if (gifs.loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        items(
                            count = gifs.itemCount,
                            key = { it }
                        ) { index ->
                            val gif = gifs[index]
                            if (gif != null) {
                                GifItem(
                                    gif = gif,
                                    modifier = Modifier.fillMaxWidth(),
                                    onItemClick = {
                                        viewModel.onEvent(GifsFeedEvent.OnGifClick(index))
                                    },
                                    onItemDelete = { viewModel.onEvent(GifsFeedEvent.OnDeleteGif(it))}
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
    }

}