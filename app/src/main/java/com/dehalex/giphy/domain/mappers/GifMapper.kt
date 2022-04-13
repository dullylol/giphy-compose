package com.dehalex.giphy.domain.mappers

import com.dehalex.giphy.data.remote.entities.gifs.GifNetwork
import com.dehalex.giphy.domain.entities.gifs.Gif

class GifMapper {

    fun toDomain(gifNetwork: GifNetwork): Gif {
        return Gif(
            id = gifNetwork.id.orEmpty(),
            title = gifNetwork.title.orEmpty(),
            username = gifNetwork.username.orEmpty(),
            originalUrl = gifNetwork.images?.original?.url.orEmpty(),
            originalWidth = gifNetwork.images?.original?.width?.toIntOrNull() ?: 0,
            originalHeight = gifNetwork.images?.original?.height?.toIntOrNull() ?: 0,
            previewUrl = gifNetwork.images?.original?.url.orEmpty(),
            previewWidth = gifNetwork.images?.preview?.width?.toIntOrNull() ?: 0,
            previewHeight = gifNetwork.images?.preview?.width?.toIntOrNull() ?: 0,
        )
    }
}