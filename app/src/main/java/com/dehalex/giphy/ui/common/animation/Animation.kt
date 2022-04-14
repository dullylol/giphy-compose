package com.dehalex.giphy.ui.common.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*

class AnimationScope<S>(
    private val defaultEnterTransition: EnterTransition = EnterTransition.None,
    private val defaultExitTransition: ExitTransition = ExitTransition.None,
) {

    private val animationItemsMutableList = mutableListOf<AnimationItem<S>>()

    fun item(
        state: S,
        enterTransition: EnterTransition? = null,
        exitTransition: ExitTransition? = null,
        content: @Composable AnimatedVisibilityScope.() -> Unit,
    ) {
        if (animationItemsMutableList.find { it.state == state } == null) {
            val animationItem = AnimationItem(
                state = state,
                enterTransition = enterTransition ?: defaultEnterTransition,
                exitTransition = exitTransition ?: defaultExitTransition,
                content,
            )
            animationItemsMutableList.add(animationItem)
        }
    }

    @Composable
    fun ShowAnimated(
        visibleState: S,
    ) {
        animationItemsMutableList.forEach { animationItem ->
            AnimatedVisibility(
                visible = animationItem.visible,
                enter = animationItem.enterTransition,
                exit = animationItem.exitTransition,
                content = animationItem.content
            )
        }

        LaunchedEffect(visibleState) {
            animationItemsMutableList.find { it.visible }?.setVisibility(false)
            animationItemsMutableList.find { it.state == visibleState }?.setVisibility(true)
        }
    }

    data class AnimationItem<S>(
        val state: S,
        val enterTransition: EnterTransition,
        val exitTransition: ExitTransition,
        val content: @Composable AnimatedVisibilityScope.() -> Unit,
    ) {

        var visible by mutableStateOf(false)
            private set

        fun setVisibility(visible: Boolean) {
            this.visible = visible
        }
    }
}

@Composable
fun <S> Animation(
    state: S,
    defaultEnterTransition: EnterTransition = EnterTransition.None,
    defaultExitTransition: ExitTransition = ExitTransition.None,
    content: AnimationScope<S>.() -> Unit,
) {
    val animationScope = remember {
        AnimationScope<S>(defaultEnterTransition, defaultExitTransition)
    }

    animationScope.content()

    Box {

        animationScope.ShowAnimated(visibleState = state)
    }
}
