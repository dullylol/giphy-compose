package com.dehalex.giphy.domain.interactors.gifs

import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsBySearchInteractor
import com.dehalex.giphy.domain.mappers.GifMapper
import javax.inject.Inject

class GetGifsBySearchInteractorDefault @Inject constructor(
    @Network private val gifsRepository: GifsRepository,
    private val gifMapper: GifMapper,
) : GetGifsBySearchInteractor {

    override suspend operator fun invoke(query: String, offset: Int, limit: Int): List<Gif> {
        return gifsRepository.getGifsBySearch(query, offset, limit).map(gifMapper::toDomain)
    }
}