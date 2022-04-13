package com.dehalex.giphy.di.domain

import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
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
}