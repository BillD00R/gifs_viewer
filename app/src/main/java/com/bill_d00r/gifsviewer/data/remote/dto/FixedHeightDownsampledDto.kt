package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class FixedHeightDownsampledDto(
    @Json(name = "height")
    val height: String = "", // 200
    @Json(name = "width")
    val width: String = "", // 300
    @Json(name = "size")
    val size: String = "", // 53658
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200_d.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200_d.gif&ct=g
    @Json(name = "webp_size")
    val webpSize: String = "", // 31266
    @Json(name = "webp")
    val webp: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/200_d.webp?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=200_d.webp&ct=g
)