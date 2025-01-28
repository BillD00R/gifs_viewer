package com.bill_d00r.gifsviewer.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["remote_id"], unique = true)], tableName = "gif_entity")
data class GifEntity(
    @PrimaryKey
    val id: Int,
    val hash: String,
    val height: String,
    val size: String,
    @ColumnInfo(name = "image_path")
    val imagePath: String,
    @ColumnInfo(name = "preview_image_path")
    val previewImagePath: String,
    val width: String,
    val title: String?,
    @ColumnInfo(name = "remote_id")
    val remoteId: String
)