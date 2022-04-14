package com.dehalex.giphy.domain.interfaces.gifs

import com.dehalex.giphy.domain.entities.gifs.Gif

interface GetTrendingGifsInteractor {

    suspend operator fun invoke(offset: Int, limit: Int): List<Gif>
}