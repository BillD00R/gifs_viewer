package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class LoopingDto(
    @Json(name = "mp4_size")
    val mp4Size: String = "", // 162952
    @Json(name = "mp4")
    val mp4: String = "" // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy-loop.mp4?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy-loop.mp4&ct=g
)