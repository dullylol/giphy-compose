package com.dehalex.giphy.ui.screens.trendgifs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dehalex.giphy.di.utils.qualifiers.dispatchers.IODispatcher
import com.dehalex.giphy.di.utils.qualifiers.interactors.Default
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.categories.Subcategory
import com.dehalex.giphy.domain.entities.gifs.Gif
import com.dehalex.giphy.domain.interfaces.categories.GetCategoriesInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsByCategoryInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsBySubcategoryInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetTrendingGifsInteractor
import com.dehalex.giphy.ui.base.BaseViewModel
import com.dehalex.giphy.ui.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class TrendingGifsViewModel @Inject constructor(
    navigator: Navigator,
    @Default private val getCategoriesInteractor: GetCategoriesInteractor,
    @Default private val getTrendingGifsInteractor: GetTrendingGifsInteractor,
    @Default private val getGifsByCategoryInteractor: GetGifsByCategoryInteractor,
    @Default private val getGifsBySubcategoryInteractor: GetGifsBySubcategoryInteractor,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : BaseViewModel(navigator) {

    var categories by mutableStateOf<List<Category>>(emptyList())
        private set

    var selectedCategoryId by mutableStateOf("")
        private set

    var selectedSubcategoryId by mutableStateOf("")
        private set

    var gifs by mutableStateOf<List<Gif>>(emptyList())
        private set

    init {

        launchSafely(ioDispatcher) {
            categories = getCategoriesInteractor()
        }

        launchSafely(ioDispatcher) {
            gifs = getTrendingGifsInteractor(0, GIFS_PAGINATION)
        }
    }

    fun onSearchButtonClicked() {
        // TODO - Implement
    }

    fun onSettingsButtonClicked() {
        // TODO - Implement
    }

    fun onCategoryClicked(category: Category?) {
        selectedCategoryId = if (selectedCategoryId == category?.id) "" else category?.id.orEmpty()
        selectedSubcategoryId = ""

        launchSafely(ioDispatcher) {
            gifs = category?.let { getGifsByCategoryInteractor(it, 0, GIFS_PAGINATION) }
                ?: getTrendingGifsInteractor(0, GIFS_PAGINATION)
        }
    }

    fun onSubcategoryClicked(subcategory: Subcategory?) {
        selectedSubcategoryId =
            if (selectedSubcategoryId == subcategory?.id) "" else subcategory?.id.orEmpty()

        launchSafely(ioDispatcher) {
            gifs = subcategory?.let { getGifsBySubcategoryInteractor(it, 0, GIFS_PAGINATION) }
                ?: getTrendingGifsInteractor(0, GIFS_PAGINATION)
        }
    }

    fun onGifClicked(gif: Gif) {
        // TODO - Implement
    }

    companion object {

        private const val GIFS_PAGINATION = 20
    }
}