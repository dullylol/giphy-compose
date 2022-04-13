package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.mappers.GifMapper

class GetTrendingGifsInteractor(
    private val remoteGifsRepository: RemoteGifsRepository,
    private val gifMapper: GifMapper,
) {

    suspend operator fun invoke(offset: Int, limit: Int): List<Gif> {
        return remoteGifsRepository.getTrendingGifs(offset, limit).map { gifNetwork ->
            gifMapper.toDomain(gifNetwork)
        }
    }
}