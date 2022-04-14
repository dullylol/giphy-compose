package com.dehalex.giphy.domain.interactors.categories

import com.dehalex.giphy.data.remote.repositories.RemoteCategoriesRepository
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.mappers.CategoryMapper

class GetCategoriesInteractor(
    private val remoteCategoriesRepository: RemoteCategoriesRepository,
    private val categoryMapper: CategoryMapper,
) {

    suspend operator fun invoke(): List<Category> {
        return remoteCategoriesRepository.getCategories().map(categoryMapper::toDomain)
    }
}