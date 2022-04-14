package com.dehalex.giphy.ui.screens

sealed interface RootState {

    object TrendGifs : RootState

    object Search : RootState

    object SearchResults : RootState

    object GifInfo : RootState
}