package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json


data class PaginationDto(
    @Json(name = "total_count")
    val totalCount: Int = 0, // 500
    @Json(name = "count")
    val count: Int = 0, // 3
    @Json(name = "offset")
    val offset: Int = 0 // 0
)