package com.bill_d00r.gifsviewer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeletedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(deletedEntity: DeletedEntity)

    @Query("SELECT * FROM deleted_entity")
    fun getDeletedGifs(): List<DeletedEntity>
}