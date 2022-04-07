package com.dehalex.giphy.presentation.navigation

import com.dehalex.giphy.presentation.screens.RootState

data class AppState(
    val rootState: RootState? = null,

    val throwable: Throwable? = null,
)