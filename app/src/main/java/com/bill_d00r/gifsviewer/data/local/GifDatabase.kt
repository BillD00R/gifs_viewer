package com.bill_d00r.gifsviewer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GifEntity::class, DeletedEntity::class], version = 1)
abstract class GifDatabase: RoomDatabase() {

    abstract val dao: GifDao
    abstract val deletedDao: DeletedDao
}