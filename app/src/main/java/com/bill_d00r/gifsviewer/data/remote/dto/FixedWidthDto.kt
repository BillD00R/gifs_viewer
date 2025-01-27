package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class FixedWidthDto(
    @Json(name = "height")
    val height: String = "", // 134
    @Json(name = "width")
    val width: String = "", // 200
    @Json(name = "size")
    val size: String = "", // 20038
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200w.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200w.gif&ct=g
    @Json(name = "mp4_size")
    val mp4Size: String = "", // 12305
    @Json(name = "mp4")
    val mp4: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200w.mp4?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200w.mp4&ct=g
    @Json(name = "webp_size")
    val webpSize: String = "", // 15642
    @Json(name = "webp")
    val webp: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200w.webp?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200w.webp&ct=g
)