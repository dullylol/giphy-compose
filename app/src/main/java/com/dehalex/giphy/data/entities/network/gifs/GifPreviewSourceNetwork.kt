package com.dehalex.giphy.data.entities.network.gifs

import com.google.gson.annotations.SerializedName

data class GifPreviewSourceNetwork(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: String?,
    @SerializedName("height") val height: String?,
)