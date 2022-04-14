package com.dehalex.giphy.ui.common.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun HeightSpacer(value: Dp) {
    Spacer(modifier = Modifier.height(value))
}