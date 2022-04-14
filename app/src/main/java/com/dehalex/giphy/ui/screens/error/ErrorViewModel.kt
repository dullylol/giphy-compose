package com.dehalex.giphy.ui.screens.error

import com.dehalex.giphy.ui.base.BaseViewModel
import com.dehalex.giphy.ui.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ErrorViewModel @Inject constructor(
    navigator: Navigator,
) : BaseViewModel(navigator) {


}