package com.dehalex.giphy.data.entities.network.gifs

import com.google.gson.annotations.SerializedName

data class GifSourcesNetwork(
    @SerializedName("preview_gif") val preview: GifPreviewSourceNetwork?,
    @SerializedName("original") val original: GifOriginalSourceNetwork?,
)