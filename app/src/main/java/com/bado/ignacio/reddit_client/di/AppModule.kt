package com.bado.ignacio.reddit_client.di

import com.bado.ignacio.reddit_client.data.EntryRemoteDataSource
import com.bado.ignacio.reddit_client.domain.EntryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindEntryRepository(repository: EntryRemoteDataSource): EntryRepository
}