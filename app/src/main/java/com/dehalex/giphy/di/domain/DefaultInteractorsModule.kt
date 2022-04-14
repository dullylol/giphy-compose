package com.dehalex.giphy.di.domain

import com.dehalex.giphy.di.utils.qualifiers.interactors.Default
import com.dehalex.giphy.domain.interactors.categories.GetCategoriesInteractorDefault
import com.dehalex.giphy.domain.interactors.gifs.GetGifsByCategoryInteractorDefault
import com.dehalex.giphy.domain.interactors.gifs.GetGifsBySearchInteractorDefault
import com.dehalex.giphy.domain.interactors.gifs.GetGifsBySubcategoryInteractorDefault
import com.dehalex.giphy.domain.interactors.gifs.GetTrendingGifsInteractorDefault
import com.dehalex.giphy.domain.interfaces.categories.GetCategoriesInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsByCategoryInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsBySearchInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetGifsBySubcategoryInteractor
import com.dehalex.giphy.domain.interfaces.gifs.GetTrendingGifsInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface DefaultInteractorsModule {

    @Binds
    @ViewModelScoped
    @Default
    fun bindGetTrendingGifsInteractor(
        getTrendingGifsInteractorDefault: GetTrendingGifsInteractorDefault,
    ): GetTrendingGifsInteractor

    @Binds
    @ViewModelScoped
    @Default
    fun bindGetGifsBySearchInteractor(
        getGifsBySearchInteractorDefault: GetGifsBySearchInteractorDefault,
    ): GetGifsBySearchInteractor

    @Binds
    @ViewModelScoped
    @Default
    fun bindGetGifsByCategoryInteractor(
        getGifsByCategoryInteractorDefault: GetGifsByCategoryInteractorDefault,
    ): GetGifsByCategoryInteractor

    @Binds
    @ViewModelScoped
    @Default
    fun bindGetGifsBySubcategoryInteractor(
        getGifsBySubcategoryInteractorDefault: GetGifsBySubcategoryInteractorDefault,
    ): GetGifsBySubcategoryInteractor

    @Binds
    @ViewModelScoped
    @Default
    fun bindGetCategoriesInteractor(
        getCategoriesInteractorDefault: GetCategoriesInteractorDefault,
    ): GetCategoriesInteractor
}