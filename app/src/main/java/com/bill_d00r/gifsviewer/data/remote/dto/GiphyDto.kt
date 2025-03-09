package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class GiphyDto(
    @Json(name = "data")
    val `data`: List<DataDto> = listOf(),
    @Json(name = "pagination")
    val pagination: PaginationDto = PaginationDto()
)