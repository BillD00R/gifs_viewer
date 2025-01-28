package com.bill_d00r.gifsviewer.data.remote

import com.bill_d00r.gifsviewer.data.remote.dto.GiphyDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface GiphyApi {

    @GET("trending")
    suspend fun getGifs(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("offset") offset: Int,
        @Query("limit") pageCount: Int
    ): GiphyDto

    @GET("search")
    suspend fun searchGifs(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("q") searchQuery: String,
        @Query("offset") offset: Int,
        @Query("limit") pageCount: Int
    ): GiphyDto

    @GET
    suspend fun downloadImage(@Url imageUrl: String): ResponseBody

    companion object {
        const val BASE_URL = "https://api.giphy.com/v1/gifs/"
        const val API_KEY = "5Qa0ydp09T50k24VyGKDYqkiskKMHJPb"
    }
}