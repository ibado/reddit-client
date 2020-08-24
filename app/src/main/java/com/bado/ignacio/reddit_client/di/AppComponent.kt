package com.bado.ignacio.reddit_client.di

import android.content.Context
import com.bado.ignacio.reddit_client.data.EntryRemoteDataSource
import com.bado.ignacio.reddit_client.domain.EntryRepository
import com.bado.ignacio.reddit_client.presentation.MainViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import java.io.Serializable

@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent : Serializable {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun getMainViewModelFactory(): MainViewModel.Factory
}

@Module
interface AppModule {

    @Binds
    fun bindEntryRepository(repository: EntryRemoteDataSource): EntryRepository
}