package com.bill_d00r.gifsviewer.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["remoteId"], unique = true)])
data class GifEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val hash: String,
    val height: String,
    val size: String,
    val imageUri: String,
    val width: String,
    val title: String?,
    val remoteId: String
)