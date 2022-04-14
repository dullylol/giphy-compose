package com.dehalex.giphy.ui.navigation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.util.*

class Navigator {

    private val _appState = mutableStateOf(AppState())
    val appState: State<AppState> = _appState

    private val backStack = Stack<AppState>()

    fun clearBackStack() = this.apply {
        backStack.clear()
    }

    fun open(action: AppState.() -> AppState) {
        _appState.value = _appState.value.action()
        backStack.add(_appState.value)
    }

    fun replace(action: AppState.() -> AppState) {
        if (backStack.size > 1) {
            backStack.pop()
        }
        open(action)
    }

    fun back(onBackStackEmpty: (() -> Unit)? = null) {
        if (backStack.size > 1) {
            backStack.pop()
            _appState.value = backStack.peek()
        } else {
            onBackStackEmpty?.invoke()
        }
    }
}