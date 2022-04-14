package com.dehalex.giphy.di.domain

import com.dehalex.giphy.domain.mappers.CategoryMapper
import com.dehalex.giphy.domain.mappers.GifMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MappersModule {

    @Provides
    @ViewModelScoped
    fun provideGifMapper() = GifMapper()

    @Provides
    @ViewModelScoped
    fun provideCategoryMapper() = CategoryMapper()
}