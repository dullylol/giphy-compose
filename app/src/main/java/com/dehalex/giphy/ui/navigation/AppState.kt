package com.dehalex.giphy.ui.navigation

import com.dehalex.giphy.ui.screens.RootState

data class AppState(
    val rootState: RootState? = null,

    val throwable: Throwable? = null,
)