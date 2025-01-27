package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class OnsentDto(
    @Json(name = "url")
    val url: String = "" // https://giphy-analytics.giphy.com/v2/pingback_simple?analytics_response_payload=e%3DZXZlbnRfdHlwZT1HSUZfVFJFTkRJTkcmY2lkPTE2NGZhNDE5OGp0Ynprd3QxMjFydnlpZzdtbXdiZ2ttNTJmYWhydWNxaTJpMGZ4aiZnaWZfaWQ9alE3ZVVXZWZ0dG5kZWFrZ2plJmN0PWc&action_type=SENT
)