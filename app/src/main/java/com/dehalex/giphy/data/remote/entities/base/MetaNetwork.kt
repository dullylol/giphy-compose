package com.dehalex.giphy.data.remote.entities.base

import com.google.gson.annotations.SerializedName

data class MetaNetwork(
    @SerializedName("msg") val message: String?,
    @SerializedName("status") val status: Int?,
)