package com.bill_d00r.gifsviewer.data.remote.repository

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.bill_d00r.gifsviewer.data.local.DeletedEntity
import com.bill_d00r.gifsviewer.data.local.GifDatabase
import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.mappers.toGifEntities
import com.bill_d00r.gifsviewer.data.remote.GifImageDownloader
import com.bill_d00r.gifsviewer.data.remote.GiphyApi
import com.bill_d00r.gifsviewer.data.remote.dto.GiphyDto
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class GiphyRemoteMediator(
    private val gifDatabase: GifDatabase,
    private val giphyApi: GiphyApi,
    private val gifImageDownloader: GifImageDownloader,
    private val searchQuery: String,
    private val initialRefresh: Boolean
) : RemoteMediator<Int, GifEntity>() {


    override suspend fun initialize(): InitializeAction {
        // Require that remote REFRESH is launched on initial load and succeeds before launching
        // remote PREPEND / APPEND.
        if (initialRefresh) {
            return InitializeAction.LAUNCH_INITIAL_REFRESH
        }
        return InitializeAction.SKIP_INITIAL_REFRESH
    }

    private suspend fun getGifs(searchQuery: String, offset: Int, pageSize: Int): GiphyDto {

        if (searchQuery != "") {
            return giphyApi.searchGifs(
                offset = offset,
                pageCount = pageSize,
                searchQuery = searchQuery
            )
        }

        return giphyApi.getGifs(
            offset = offset,
            pageCount = pageSize
        )
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GifEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()

                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val pageCount = state.config.pageSize
            val offset = (loadKey - 1) * pageCount

            Log.d(
                "CURRENT_OFFSET",
                "Offset: $offset PageSize: $pageCount Anchor: ${state.anchorPosition}"
            )

            val giphyDto = getGifs(
                searchQuery,
                offset = offset,
                pageSize = state.config.pageSize
            )

            gifDatabase.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    gifDatabase.dao.clearAll()
                }

                val gifEntities =
                    giphyDto.toGifEntities(gifImageDownloader, offset).filter { gifEntity ->
                        isNotDeleted(gifEntity)
                    }
                gifDatabase.dao.insertAll(gifEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = giphyDto.data.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun isNotDeleted(gifEntity: GifEntity): Boolean {
        val deletedEntities = gifDatabase.deletedDao.getDeletedGifs().map { it.deletedId }
        return !deletedEntities.contains(gifEntity.remoteId)
    }
}