package com.dehalex.giphy.presentation.base

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dehalex.giphy.presentation.navigation.Navigator
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseViewModel(
    protected val navigator: Navigator,
) : ViewModel(), CoroutineScope {

    val appState by navigator.appState

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("COROUTINE_EXCEPTION", "$throwable")
        onCoroutineException(throwable)
    }

    override val coroutineContext =
        viewModelScope.coroutineContext + Dispatchers.IO + coroutineExceptionHandler

    protected open fun onCoroutineException(throwable: Throwable) {
        navigator.open { copy(throwable = throwable) }
    }
}