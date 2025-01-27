package com.bill_d00r.gifsviewer.presentation.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.bill_d00r.gifsviewer.presentation.CoilGifImage
import com.bill_d00r.gifsviewer.presentation.GifsFeedViewModel
import com.bill_d00r.gifsviewer.presentation.util.UiEvent
import kotlinx.coroutines.launch

@Composable
fun GifsCarouselScreen(
    viewModel: GifsFeedViewModel,
    onPopBackStack: () -> Unit,
    initialId: Int
) {
    val gifs = viewModel.gifsPagingFlow.collectAsLazyPagingItems()
    val pagerState = rememberPagerState(
        initialPage = initialId-1, //Because pages numeration starts with 0 and gif id's starts with 1
        pageCount = { gifs.itemCount }
    )
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill
        ) { index ->
            val gif = gifs[index]
            if (gif != null) {
                CoilGifImage(
                    gif.imageUri,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Box(
            modifier = Modifier
                .offset(y = -(16).dp)
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ) {
            IconButton(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage - 1
                        )
                    }
                },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Go back"
                )
            }
            IconButton(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Go forward"
                )
            }
        }
    }
}