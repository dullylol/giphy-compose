package com.dehalex.giphy.data.remote.repositories

import com.dehalex.giphy.data.remote.GiphyApiCalls
import com.dehalex.giphy.data.remote.entities.gifs.GifNetwork

class RemoteGifsRepository(
    private val giphyApiCalls: GiphyApiCalls,
) {

    suspend fun getTrendingGifs(offset: Int, limit: Int): List<GifNetwork> {
        return giphyApiCalls.getTrendingGifs(offset = offset, limit = limit).data ?: emptyList()
    }

    suspend fun getGifsBySearch(query: String, offset: Int, limit: Int): List<GifNetwork> {
        return giphyApiCalls.getGifsBySearch(query = query, offset = offset, limit = limit).data
            ?: emptyList()
    }
}