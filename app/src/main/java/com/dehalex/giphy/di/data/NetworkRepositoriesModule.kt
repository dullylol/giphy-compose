package com.dehalex.giphy.di.data

import com.dehalex.giphy.data.repositories.interfaces.CategoriesRepository
import com.dehalex.giphy.data.repositories.interfaces.GifsRepository
import com.dehalex.giphy.data.repositories.network.CategoriesRepositoryNetwork
import com.dehalex.giphy.data.repositories.network.GifsRepositoryNetwork
import com.dehalex.giphy.di.utils.qualifiers.repositories.Network
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkRepositoriesModule {

    @Binds
    @Singleton
    @Network
    fun bindGifsRepositoryNetwork(
        gifsRepositoryNetwork: GifsRepositoryNetwork,
    ): GifsRepository

    @Binds
    @Singleton
    @Network
    fun bindCategoriesRepositoryNetwork(
        categoriesRepositoryNetwork: CategoriesRepositoryNetwork,
    ): CategoriesRepository
}