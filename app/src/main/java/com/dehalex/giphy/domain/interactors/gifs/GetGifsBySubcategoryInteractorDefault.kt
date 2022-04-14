package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import com.dehalex.giphy.domain.entities.categories.Subcategory
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsBySubcategoryInteractor
import com.dehalex.giphy.domain.mappers.GifMapper
import javax.inject.Inject

class GetGifsBySubcategoryInteractorDefault @Inject constructor(
    @Network private val gifsRepository: GifsRepository,
    private val gifMapper: GifMapper,
) : GetGifsBySubcategoryInteractor {

    override suspend operator fun invoke(
        subcategory: Subcategory,
        offset: Int,
        limit: Int,
    ): List<Gif> {
        return gifsRepository.getGifsBySearch(query = subcategory.name, offset, limit)
            .map(gifMapper::toDomain)
    }
}