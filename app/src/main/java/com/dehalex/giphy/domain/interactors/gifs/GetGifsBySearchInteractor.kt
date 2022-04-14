package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.mappers.GifMapper

class GetGifsBySearchInteractor(
    private val remoteGifsRepository: RemoteGifsRepository,
    private val gifMapper: GifMapper,
) {

    suspend operator fun invoke(query: String, offset: Int, limit: Int): List<Gif> {
        return remoteGifsRepository.getGifsBySearch(query, offset, limit).map(gifMapper::toDomain)
    }
}