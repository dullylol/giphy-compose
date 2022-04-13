package com.dehalex.giphy.data.remote.entities.base

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("meta") val meta: MetaNetwork?,
)