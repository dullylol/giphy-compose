package com.dehalex.giphy.domain.entities.gifs

data class Gif(
    val id: String,
    val title: String,
    val username: String,
    val originalUrl: String?,
    val originalWidth: Int,
    val originalHeight: Int,
    val previewUrl: String?,
    val previewWidth: Int,
    val previewHeight: Int,
)