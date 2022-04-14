package com.dehalex.giphy.data.entities.network.gifs

import com.google.gson.annotations.SerializedName

data class GifNetwork(
    @SerializedName("id") val id: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("images") val images: GifSourcesNetwork?,
)
