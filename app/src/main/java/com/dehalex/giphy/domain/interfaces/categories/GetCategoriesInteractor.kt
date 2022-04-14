package com.dehalex.giphy.domain.interfaces.categories

import com.dehalex.giphy.domain.entities.categories.Category

interface GetCategoriesInteractor {

    suspend operator fun invoke(): List<Category>
}