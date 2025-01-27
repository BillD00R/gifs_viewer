package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class DataDto(
    @Json(name = "type")
    val type: String = "", // gif
    @Json(name = "id")
    val id: String = "", // jQ7eUWefttndeakgje
    @Json(name = "url")
    val url: String = "", // https://giphy.com/gifs/happy-birthday-koimoffee-happybirthday-jQ7eUWefttndeakgje
    @Json(name = "slug")
    val slug: String = "", // happy-birthday-koimoffee-happybirthday-jQ7eUWefttndeakgje
    @Json(name = "bitly_gif_url")
    val bitlyGifUrl: String = "", // https://gph.is/g/amjqNlY
    @Json(name = "bitly_url")
    val bitlyUrl: String = "", // https://gph.is/g/amjqNlY
    @Json(name = "embed_url")
    val embedUrl: String = "", // https://giphy.com/embed/jQ7eUWefttndeakgje
    @Json(name = "username")
    val username: String = "", // koimoffee
    @Json(name = "source")
    val source: String = "",
    @Json(name = "title")
    val title: String = "", // Happy Birthday GIF by koimoffee
    @Json(name = "rating")
    val rating: String = "", // g
    @Json(name = "content_url")
    val contentUrl: String = "",
    @Json(name = "source_tld")
    val sourceTld: String = "",
    @Json(name = "source_post_url")
    val sourcePostUrl: String = "",
    @Json(name = "is_sticker")
    val isSticker: Int = 0, // 0
    @Json(name = "import_datetime")
    val importDatetime: String = "", // 2025-01-22 02:01:37
    @Json(name = "trending_datetime")
    val trendingDatetime: String = "", // 0000-00-00 00:00:00
    @Json(name = "images")
    val images: ImagesDto = ImagesDto(),
    @Json(name = "user")
    val user: UserDto? = null,
    @Json(name = "analytics_response_payload")
    val analyticsResponsePayload: String = "", // e=ZXZlbnRfdHlwZT1HSUZfVFJFTkRJTkcmY2lkPTE2NGZhNDE5OGp0Ynprd3QxMjFydnlpZzdtbXdiZ2ttNTJmYWhydWNxaTJpMGZ4aiZnaWZfaWQ9alE3ZVVXZWZ0dG5kZWFrZ2plJmN0PWc
    @Json(name = "analytics")
    val analytics: AnalyticsDto = AnalyticsDto(),
    @Json(name = "alt_text")
    val altText: String = ""
)