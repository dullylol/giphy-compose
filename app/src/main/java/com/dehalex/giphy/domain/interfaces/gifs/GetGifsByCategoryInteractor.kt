package com.dehalex.giphy.domain.interfaces.gifs

import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.gifs.Gif

interface GetGifsByCategoryInteractor {

    suspend operator fun invoke(category: Category, offset: Int, limit: Int): List<Gif>
}