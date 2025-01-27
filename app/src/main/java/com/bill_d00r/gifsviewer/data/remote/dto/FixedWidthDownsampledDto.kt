package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class FixedWidthDownsampledDto(
    @Json(name = "height")
    val height: String = "", // 134
    @Json(name = "width")
    val width: String = "", // 200
    @Json(name = "size")
    val size: String = "", // 30021
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200w_d.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200w_d.gif&ct=g
    @Json(name = "webp_size")
    val webpSize: String = "", // 17788
    @Json(name = "webp")
    val webp: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200w_d.webp?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200w_d.webp&ct=g
)