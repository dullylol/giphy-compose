package com.dehalex.giphy.data.remote.entities.base

import com.google.gson.annotations.SerializedName

data class DataResponse<D>(
    @SerializedName("data") val data: D?,
)