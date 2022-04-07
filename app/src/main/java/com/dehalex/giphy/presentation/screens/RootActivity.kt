package com.dehalex.giphy.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dehalex.giphy.presentation.common.usages.NotImplemented
import com.dehalex.giphy.presentation.common.usages.NotSupported
import com.dehalex.giphy.presentation.screens.error.ErrorComponent
import com.dehalex.giphy.presentation.screens.trendgifs.TrendingGifsComponent
import com.dehalex.giphy.values.themes.AppThemes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val rootViewModel: RootViewModel = viewModel()

            BackHandler { rootViewModel.onBackClicked(::finish) }

            MaterialTheme(
                colors = AppThemes.colors,
            ) {

                when (rootViewModel.appState.rootState) {

                    is RootState.TrendGifs -> TrendingGifsComponent()

                    is RootState.GifInfo -> NotImplemented()

                    is RootState.Search -> NotImplemented()

                    is RootState.SearchResults -> NotImplemented()

                    else -> NotSupported()
                }

                rootViewModel.appState.throwable?.let { throwable ->

                    ErrorComponent(throwable)
                }
            }
        }
    }
}