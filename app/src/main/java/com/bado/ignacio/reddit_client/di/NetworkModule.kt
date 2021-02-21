package com.bado.ignacio.reddit_client.di

import com.bado.ignacio.reddit_client.BuildConfig
import com.bado.ignacio.reddit_client.data.TopService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideTopService(retrofit: Retrofit): TopService {
        return retrofit.create(TopService::class.java)
    }
}
