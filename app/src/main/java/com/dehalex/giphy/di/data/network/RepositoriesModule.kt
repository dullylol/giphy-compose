package com.dehalex.giphy.di.data.network

import com.dehalex.giphy.data.remote.GiphyApiCalls
import com.dehalex.giphy.data.remote.repositories.RemoteGifsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideRemoteGifsRepository(
        giphyApiCalls: GiphyApiCalls,
    ): RemoteGifsRepository {
        return RemoteGifsRepository(giphyApiCalls)
    }
}