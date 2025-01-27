package com.bill_d00r.gifsviewer.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GifDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(gifs: List<GifEntity>)

    @Query("SELECT * FROM gifentity")
    fun pagingSource(): PagingSource<Int, GifEntity>

    @Query("DELETE FROM gifentity")
    suspend fun clearAll()

}