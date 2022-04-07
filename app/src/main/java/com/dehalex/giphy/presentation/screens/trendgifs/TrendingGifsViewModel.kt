package com.dehalex.giphy.presentation.screens.trendgifs

import com.dehalex.giphy.presentation.base.BaseViewModel
import com.dehalex.giphy.presentation.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrendingGifsViewModel @Inject constructor(
    navigator: Navigator,
) : BaseViewModel(navigator) {


}