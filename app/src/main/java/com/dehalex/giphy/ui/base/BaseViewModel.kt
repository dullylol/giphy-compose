package com.dehalex.giphy.ui.base

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dehalex.giphy.BuildConfig
import com.dehalex.giphy.ui.navigation.Navigator
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(
    protected val navigator: Navigator,
) : ViewModel() {

    val appState by navigator.appState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onCoroutineException(throwable)

        if (BuildConfig.DEBUG) {
            Log.e("COROUTINE_EXCEPTION", "$throwable")
        }
    }

    protected fun launchSafely(
        context: CoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit,
    ) {
        viewModelScope.launch(
            context = coroutineExceptionHandler + context,
            start = start,
            block = block,
        )
    }

    protected fun launchSafelyWithLoading(
        context: CoroutineContext,
        loadingState: MutableState<Boolean>,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit,
    ) {
        launchSafely(
            context = context,
            start = start,
        ) {
            loadingState.value = true
            block()
            loadingState.value = false
        }
    }

    protected open fun onCoroutineException(throwable: Throwable) {
        navigator.open { copy(throwable = throwable) }
    }
}