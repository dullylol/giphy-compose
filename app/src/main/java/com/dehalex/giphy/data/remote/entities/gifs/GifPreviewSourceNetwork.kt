package com.dehalex.giphy.data.remote.entities.gifs

import com.google.gson.annotations.SerializedName

data class GifPreviewSourceNetwork(
    @SerializedName("mp4") val url: String?,
    @SerializedName("width") val width: String?,
    @SerializedName("height") val height: String?,
)