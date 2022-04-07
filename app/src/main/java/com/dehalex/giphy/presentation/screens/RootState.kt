package com.dehalex.giphy.presentation.screens

sealed interface RootState {

    object TrendGifs : RootState

    object Search : RootState

    object SearchResults : RootState

    object GifInfo : RootState
}