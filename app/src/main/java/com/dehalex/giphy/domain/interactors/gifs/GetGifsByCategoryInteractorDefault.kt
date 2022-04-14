package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsByCategoryInteractor
import com.dehalex.giphy.domain.mappers.GifMapper
import javax.inject.Inject

class GetGifsByCategoryInteractorDefault @Inject constructor(
    @Network private val gifsRepository: GifsRepository,
    private val gifMapper: GifMapper,
) : GetGifsByCategoryInteractor {

    override suspend operator fun invoke(category: Category, offset: Int, limit: Int): List<Gif> {
        return gifsRepository.getGifsBySearch(query = category.name, offset, limit)
            .map(gifMapper::toDomain)
    }
}