package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class AnalyticsDto(
    @Json(name = "onload")
    val onload: OnloadDto = OnloadDto(),
    @Json(name = "onclick")
    val onclick: OnclickDto = OnclickDto(),
    @Json(name = "onsent")
    val onsent: OnsentDto = OnsentDto()
)