package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class OriginalDto(
    @Json(name = "height")
    val height: String = "", // 320
    @Json(name = "width")
    val width: String = "", // 480
    @Json(name = "size")
    val size: String = "", // 64793
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy.gif&ct=g
    @Json(name = "mp4_size")
    val mp4Size: String = "", // 49259
    @Json(name = "mp4")
    val mp4: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy.mp4?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy.mp4&ct=g
    @Json(name = "webp_size")
    val webpSize: String = "", // 58708
    @Json(name = "webp")
    val webp: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy.webp?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy.webp&ct=g
    @Json(name = "frames")
    val frames: String = "", // 2
    @Json(name = "hash")
    val hash: String = "" // ea8a93f1921b2c99600dd302e7554d5d
)