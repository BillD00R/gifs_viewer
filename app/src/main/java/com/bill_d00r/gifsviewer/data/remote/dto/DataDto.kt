package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class DataDto(
    @Json(name = "type")
    val type: String = "", // gif
    @Json(name = "id")
    val id: String = "", // jQ7eUWefttndeakgje
    @Json(name = "url")
    val url: String = "", // https://giphy.com/gifs/happy-birthday-koimoffee-happybirthday-jQ7eUWefttndeakgje
    @Json(name = "username")
    val username: String = "", // koimoffee
    @Json(name = "title")
    val title: String = "", // Happy Birthday GIF by koimoffee

    @Json(name = "images")
    val images: ImagesDto = ImagesDto(),

)