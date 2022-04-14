package com.dehalex.giphy.di.domain

import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
import com.dehalex.giphy.domain.interactors.gifs.GetGifsByCategoryInteractor
import com.dehalex.giphy.domain.interactors.gifs.GetGifsBySearchInteractor
import com.dehalex.giphy.domain.interactors.gifs.GetGifsBySubcategoryInteractor
import com.dehalex.giphy.domain.interactors.gifs.GetTrendingGifsInteractor
import com.dehalex.giphy.domain.mappers.GifMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class InteractorsModule {

    @Provides
    @ViewModelScoped
    fun provideGetTrendingGifsInteractor(
        remoteGifsRepository: RemoteGifsRepository,
        gifMapper: GifMapper,
    ): GetTrendingGifsInteractor {
        return GetTrendingGifsInteractor(remoteGifsRepository, gifMapper)
    }

    @Provides
    @ViewModelScoped
    fun provideGetGifsBySearchInteractor(
        remoteGifsRepository: RemoteGifsRepository,
        gifMapper: GifMapper,
    ): GetGifsBySearchInteractor {
        return GetGifsBySearchInteractor(remoteGifsRepository, gifMapper)
    }

    @Provides
    @ViewModelScoped
    fun provideGetGifsByCategoryInteractor(
        remoteGifsRepository: RemoteGifsRepository,
        gifMapper: GifMapper,
    ): GetGifsByCategoryInteractor {
        return GetGifsByCategoryInteractor(remoteGifsRepository, gifMapper)
    }

    @Provides
    @ViewModelScoped
    fun provideGetGifsBySubcategoryInteractor(
        remoteGifsRepository: RemoteGifsRepository,
        gifMapper: GifMapper,
    ): GetGifsBySubcategoryInteractor {
        return GetGifsBySubcategoryInteractor(remoteGifsRepository, gifMapper)
    }
}