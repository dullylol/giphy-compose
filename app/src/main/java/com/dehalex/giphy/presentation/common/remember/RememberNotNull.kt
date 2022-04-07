package com.dehalex.giphy.presentation.common.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.cache
import androidx.compose.runtime.currentComposer

@Composable
fun <T> rememberNotNull(
    key: T,
): T {
    return currentComposer.cache(
        invalid = if (key != null) currentComposer.changed(key) else false,
        block = { key },
    )
}