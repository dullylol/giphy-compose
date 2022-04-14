package com.dehalex.giphy.domain.interactors.categories

import com.dehalex.giphy.data.repositories.interfaces.CategoriesRepository
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.interfaces.categories.GetCategoriesInteractor
import com.dehalex.giphy.domain.mappers.CategoryMapper
import javax.inject.Inject

class GetCategoriesInteractorDefault @Inject constructor(
    @Network private val categoriesRepository: CategoriesRepository,
    private val categoryMapper: CategoryMapper,
) : GetCategoriesInteractor {

    override suspend operator fun invoke(): List<Category> {
        return categoriesRepository.getCategories().map(categoryMapper::toDomain)
    }
}