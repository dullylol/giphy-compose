package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.interfaces.gifs.GetTrendingGifsInteractor
import com.dehalex.giphy.domain.mappers.GifMapper
import javax.inject.Inject

class GetTrendingGifsInteractorDefault @Inject constructor(
    @Network private val gifsRepository: GifsRepository,
    private val gifMapper: GifMapper,
) : GetTrendingGifsInteractor {

    override suspend operator fun invoke(offset: Int, limit: Int): List<Gif> {
        return gifsRepository.getTrendingGifs(offset, limit).map(gifMapper::toDomain)
    }
}