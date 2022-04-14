package com.dehalex.giphy.data.entities.network.categories

import com.google.gson.annotations.SerializedName

data class SubcategoryNetwork(
    @SerializedName("name_encoded") val id: String?,
    @SerializedName("name") val name: String?,
)