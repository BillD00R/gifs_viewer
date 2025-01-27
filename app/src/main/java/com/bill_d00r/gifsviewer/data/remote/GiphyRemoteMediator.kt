package com.bill_d00r.gifsviewer.data.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.bill_d00r.gifsviewer.data.local.GifDatabase
import com.bill_d00r.gifsviewer.data.local.GifEntity
import com.bill_d00r.gifsviewer.data.mappers.toGifEntities
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class GiphyRemoteMediator(
    private val gifDatabase: GifDatabase,
    private val giphyApi: GiphyApi,
    private val gifImageDownloader: GifImageDownloader
) : RemoteMediator<Int, GifEntity>() {

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


            val giphyDto = giphyApi.getGifs(
                offset = offset,
                pageCount = state.config.pageSize
            )


            gifDatabase.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    gifDatabase.dao.clearAll()
                }
                val gifEntities = giphyDto.toGifEntities(gifImageDownloader, offset)
                gifDatabase.dao.upsertAll(gifEntities)
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
}