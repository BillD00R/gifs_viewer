package com.bill_d00r.gifsviewer.data.remote.dto

import com.squareup.moshi.Json

data class ImageDto(
    @Json(name = "url")
    val url: String = "", // https://media1.giphy.com/media/jQ7eUWefttndeakgje/giphy.gif?cid=164fa4198jtbzkwt121rvyig7mmwbgkm52fahrucqi2i0fxj&ep=v1_gifs_trending&rid=giphy.gif&ct=g
    @Json(name = "hash")
    val hash: String = "", // ea8a93f1921b2c99600dd302e7554d5d
)
