package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.mappers.GifMapper

class GetGifsByCategoryInteractor(
    private val remoteGifsRepository: RemoteGifsRepository,
    private val gifMapper: GifMapper,
) {

    suspend operator fun invoke(category: Category, offset: Int, limit: Int): List<Gif> {
        return remoteGifsRepository.getGifsBySearch(query = category.name, offset, limit)
            .map(gifMapper::toDomain)
    }
}