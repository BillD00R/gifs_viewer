package com.bill_d00r.gifsviewer.data.remote.dto


import com.squareup.moshi.Json

data class UserDto(
    @Json(name = "avatar_url")
    val avatarUrl: String = "", // https://media4.giphy.com/avatars/choko9ma/GW89uiFyxIf3.gif
    @Json(name = "banner_image")
    val bannerImage: String = "",
    @Json(name = "banner_url")
    val bannerUrl: String = "",
    @Json(name = "profile_url")
    val profileUrl: String = "", // https://giphy.com/koimoffee/
    @Json(name = "username")
    val username: String = "", // koimoffee
    @Json(name = "display_name")
    val displayName: String = "", // koimoffee
    @Json(name = "description")
    val description: String = "", // The charm of cats is infinite!
    @Json(name = "instagram_url")
    val instagramUrl: String = "", // https://instagram.com/koimoffee
    @Json(name = "website_url")
    val websiteUrl: String = "", // https://lit.link/koimoffee
    @Json(name = "is_verified")
    val isVerified: Boolean = false // true
)