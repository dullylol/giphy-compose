package com.dehalex.giphy.data.repositories.network

import com.dehalex.giphy.data.datasources.network.GiphyApiCalls
import com.dehalex.giphy.data.entities.network.categories.CategoryNetwork
import com.dehalex.giphy.data.repositories.interfaces.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryNetwork @Inject constructor(
    private val giphyApiCalls: GiphyApiCalls,
) : CategoriesRepository {

    override suspend fun getCategories(): List<CategoryNetwork> {
        return giphyApiCalls.getCategories().data ?: emptyList()
    }
}