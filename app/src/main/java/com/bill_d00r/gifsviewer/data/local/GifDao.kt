package com.bill_d00r.gifsviewer.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GifDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(gifs: List<GifEntity>)

    @Query("SELECT * FROM gif_entity")
    fun pagingSource(): PagingSource<Int, GifEntity>

    @Query("DELETE FROM gif_entity")
    suspend fun clearAll()

    @Query("DELETE FROM gif_entity WHERE remote_id = :remoteId")
    suspend fun delete(remoteId: String)

}