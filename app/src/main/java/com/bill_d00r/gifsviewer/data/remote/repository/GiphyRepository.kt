package com.bill_d00r.gifsviewer.data.remote.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import com.bill_d00r.gifsviewer.data.local.GifEntity

interface GiphyRepository {
    @OptIn(ExperimentalPagingApi::class)
    fun getGifs(searchQuery: String): Pager<Int, GifEntity>
    fun deleteGif(remoteId: String)
}