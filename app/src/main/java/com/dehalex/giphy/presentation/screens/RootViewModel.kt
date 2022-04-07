package com.dehalex.giphy.presentation.screens

import com.dehalex.giphy.presentation.base.BaseViewModel
import com.dehalex.giphy.presentation.navigation.AppState
import com.dehalex.giphy.presentation.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    navigator: Navigator,
) : BaseViewModel(navigator) {

    init {
        navigator.clearBackStack().open { AppState(rootState = RootState.TrendGifs) }
    }

    fun onBackClicked(onBackStackEmpty: (() -> Unit)? = null) {
        navigator.back(onBackStackEmpty)
    }
}