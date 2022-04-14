package com.dehalex.giphy.data.repositories.interfaces

import com.dehalex.giphy.data.entities.network.gifs.GifNetwork

interface GifsRepository {

    suspend fun getTrendingGifs(offset: Int, limit: Int): List<GifNetwork>

    suspend fun getGifsBySearch(query: String, offset: Int, limit: Int): List<GifNetwork>
}