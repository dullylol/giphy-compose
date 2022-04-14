package com.dehalex.giphy.domain.mappers

import com.dehalex.giphy.data.entities.network.categories.CategoryNetwork
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.categories.Subcategory
import javax.inject.Inject

class CategoryMapper @Inject constructor() {

    fun toDomain(categoryNetwork: CategoryNetwork): Category {
        return Category(
            id = categoryNetwork.id.orEmpty(),
            name = categoryNetwork.name.orEmpty(),
            subcategories = categoryNetwork.subcategories?.map { subcategoryNetwork ->
                Subcategory(
                    id = subcategoryNetwork.id.orEmpty(),
                    name = subcategoryNetwork.name.orEmpty(),
                )
            } ?: emptyList(),
        )
    }
}