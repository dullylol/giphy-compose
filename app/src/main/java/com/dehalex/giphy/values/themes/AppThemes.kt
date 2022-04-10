package com.dehalex.giphy.values.themes

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dehalex.giphy.values.themes.colors.defaultLightColors

object AppThemes {

    var colors by mutableStateOf(defaultLightColors)
        private set

    fun updateColors(colors: Colors) {
        this.colors = colors
    }
}