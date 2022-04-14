package com.dehalex.giphy.di.ui

import com.dehalex.giphy.di.utils.qualifiers.dispatchers.DefaultDispatcher
import com.dehalex.giphy.di.utils.qualifiers.dispatchers.IODispatcher
import com.dehalex.giphy.di.utils.qualifiers.dispatchers.MainDispatcher
import com.dehalex.giphy.di.utils.qualifiers.dispatchers.UnconfinedDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class DispatchersModule {

    @Provides
    @ViewModelScoped
    @IODispatcher
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @ViewModelScoped
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @ViewModelScoped
    @UnconfinedDispatcher
    fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined

    @Provides
    @ViewModelScoped
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}