package com.dehalex.giphy.data.entities.network.base

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("meta") val meta: MetaNetwork?,
)