package com.dehalex.giphy.presentation.common.system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemBars(
    color: Color,
    useDarkIcons: Boolean = false,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = color,
        darkIcons = useDarkIcons,
    )
}

@Composable
fun StatusBar(
    color: Color,
    useDarkIcons: Boolean = false,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(color, useDarkIcons)
}

@Composable
fun NavigationBar(
    color: Color,
    useDarkIcons: Boolean = false,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setNavigationBarColor(color, useDarkIcons)
}
