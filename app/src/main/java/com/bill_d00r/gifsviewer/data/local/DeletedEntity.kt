package com.bill_d00r.gifsviewer.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deleted_entity")
class DeletedEntity (
    @PrimaryKey
    @ColumnInfo(name = "deleted_remote_id")
    val deletedId: String
)