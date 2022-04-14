package com.dehalex.giphy.data.remote

import com.dehalex.giphy.BuildConfig
import com.dehalex.giphy.data.remote.entities.base.DataResponse
import com.dehalex.giphy.data.remote.entities.categories.CategoryNetwork
import com.dehalex.giphy.data.remote.entities.gifs.GifNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApiCalls {

    @GET("gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): DataResponse<List<GifNetwork>>

    @GET("gifs/search")
    suspend fun getGifsBySearch(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("q") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): DataResponse<List<GifNetwork>>

    @GET("gifs/categories")
    suspend fun getCategories(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): DataResponse<List<CategoryNetwork>>
}