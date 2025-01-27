package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class FixedHeightSmallDto(
    @Json(name = "height")
    val height: String = "", // 100
    @Json(name = "width")
    val width: String = "", // 150
    @Json(name = "size")
    val size: String = "", // 12824
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/100.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=100.gif&ct=g
    @Json(name = "mp4_size")
    val mp4Size: String = "", // 8707
    @Json(name = "mp4")
    val mp4: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/100.mp4?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=100.mp4&ct=g
    @Json(name = "webp_size")
    val webpSize: String = "", // 10314
    @Json(name = "webp")
    val webp: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/100.webp?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=100.webp&ct=g
)