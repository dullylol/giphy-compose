package com.dehalex.giphy.domain.interfaces.gifs

import com.dehalex.giphy.domain.entities.gifs.Gif

interface GetGifsBySearchInteractor {

    suspend operator fun invoke(query: String, offset: Int, limit: Int): List<Gif>
}