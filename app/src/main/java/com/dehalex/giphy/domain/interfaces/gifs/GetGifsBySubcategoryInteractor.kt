package com.dehalex.giphy.domain.interfaces.gifs

import com.dehalex.giphy.domain.entities.categories.Subcategory
import com.dehalex.giphy.domain.entities.gifs.Gif

interface GetGifsBySubcategoryInteractor {

    suspend operator fun invoke(subcategory: Subcategory, offset: Int, limit: Int): List<Gif>
}