package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class PreviewGifDto(
    @Json(name = "height")
    val height: String = "", // 68
    @Json(name = "width")
    val width: String = "", // 100
    @Json(name = "size")
    val size: String = "", // 7743
    @Json(name = "url")
    val url: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/100w.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=100w.gif&ct=g
)