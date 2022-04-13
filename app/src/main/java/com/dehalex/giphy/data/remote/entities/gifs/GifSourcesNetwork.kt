package com.dehalex.giphy.data.remote.entities.gifs

import com.google.gson.annotations.SerializedName

data class GifSourcesNetwork(
    @SerializedName("preview") val preview: GifPreviewSourceNetwork?,
    @SerializedName("original") val original: GifOriginalSourceNetwork?,
)