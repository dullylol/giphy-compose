package com.dehalex.giphy.ui.common.modifier.clickable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.onClickWithRippleAnimation(
    bounded: Boolean = true,
    radius: Dp = Dp.Unspecified,
    color: Color = Color.Unspecified,
    onClick: () -> Unit,
) = composed(
    factory = {
        clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(
                bounded = bounded,
                radius = radius,
                color = color,
            ),
            onClick = onClick,
        )
    }
)