package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class FixedHeightSmallStillDto(
    @Json(name = "height")
    val height: String = "", // 100
    @Json(name = "width")
    val width: String = "", // 150
    @Json(name = "size")
    val size: String = "", // 6479
    @Json(name = "url")
    val url: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/100_s.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=100_s.gif&ct=g
)