package com.dehalex.giphy.data.remote.repositories

import com.dehalex.giphy.data.remote.GiphyApiCalls
import com.dehalex.giphy.data.remote.entities.categories.CategoryNetwork

class RemoteCategoriesRepository(
    private val giphyApiCalls: GiphyApiCalls,
) {

    suspend fun getCategories(): List<CategoryNetwork> {
        return giphyApiCalls.getCategories().data ?: emptyList()
    }
}