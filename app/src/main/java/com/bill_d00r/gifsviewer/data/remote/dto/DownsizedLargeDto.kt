package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class DownsizedLargeDto(
    @Json(name = "height")
    val height: String = "", // 320
    @Json(name = "width")
    val width: String = "", // 480
    @Json(name = "size")
    val size: String = "", // 64793
    @Json(name = "url")
    val url: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy.gif&ct=g
)