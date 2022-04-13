package com.dehalex.giphy.data.remote.entities.categories

import com.google.gson.annotations.SerializedName

data class CategoryNetwork(
    @SerializedName("name_encoded") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("subcategories") val subcategories: List<SubcategoryNetwork>?,
)