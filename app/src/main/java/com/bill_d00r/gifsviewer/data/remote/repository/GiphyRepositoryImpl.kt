package com.bill_d00r.gifsviewer.data.remote.repository

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.withTransaction
import com.bill_d00r.gifsviewer.data.local.DeletedEntity
import com.bill_d00r.gifsviewer.data.local.GifDatabase
import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloader
import com.bill_d00r.gifsviewer.data.remote.GiphyApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val gifDb: GifDatabase,
    private val giphyApi: GiphyApi,
    private val gifImageDownloader: GifImageDownloader
) : GiphyRepository {


    @OptIn(ExperimentalPagingApi::class)
    override fun getGifs(searchQuery: String): Pager<Int, GifEntity> {
        Log.d("SEARCH_QUERY", "In Repository: ${searchQuery}")
        return Pager(
            config = PagingConfig(
                pageSize = 4
            ),
            remoteMediator = GiphyRemoteMediator(
                gifDatabase = gifDb,
                giphyApi = giphyApi,
                gifImageDownloader = gifImageDownloader,
                searchQuery = searchQuery,
                initialRefresh = true
            ),
            pagingSourceFactory = {
                gifDb.dao.pagingSource()
            }
        )
    }

    override fun deleteGif(remoteId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            gifDb.withTransaction {
                gifDb.dao.delete(remoteId)
                gifDb.deletedDao.insert(DeletedEntity(deletedId = remoteId))
            }
        }
    }


}