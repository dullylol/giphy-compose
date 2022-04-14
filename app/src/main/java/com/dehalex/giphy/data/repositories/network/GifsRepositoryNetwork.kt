package com.dehalex.giphy.data.repositories.network

import com.dehalex.giphy.data.datasources.network.GiphyApiCalls
import com.dehalex.giphy.data.entities.network.gifs.GifNetwork
import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import javax.inject.Inject

class GifsRepositoryNetwork @Inject constructor(
    private val giphyApiCalls: GiphyApiCalls,
) : GifsRepository {

    override suspend fun getTrendingGifs(offset: Int, limit: Int): List<GifNetwork> {
        return giphyApiCalls.getTrendingGifs(offset = offset, limit = limit).data ?: emptyList()
    }

    override suspend fun getGifsBySearch(query: String, offset: Int, limit: Int): List<GifNetwork> {
        return giphyApiCalls.getGifsBySearch(query = query, offset = offset, limit = limit).data
            ?: emptyList()
    }
}