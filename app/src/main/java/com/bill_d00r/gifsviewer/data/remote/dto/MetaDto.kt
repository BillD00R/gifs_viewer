package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class MetaDto(
    @Json(name = "status")
    val status: Int = 0, // 200
    @Json(name = "msg")
    val msg: String = "", // OK
    @Json(name = "response_id")
    val responseId: String = "" // 8jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj
)