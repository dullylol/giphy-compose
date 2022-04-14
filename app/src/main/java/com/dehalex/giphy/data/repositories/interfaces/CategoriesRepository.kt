package com.dehalex.giphy.data.repositories.interfaces

import com.dehalex.giphy.data.entities.network.categories.CategoryNetwork

interface CategoriesRepository {

    suspend fun getCategories(): List<CategoryNetwork>
}