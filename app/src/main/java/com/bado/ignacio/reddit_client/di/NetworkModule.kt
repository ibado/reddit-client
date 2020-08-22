package com.bado.ignacio.reddit_client.di

import com.bado.ignacio.reddit_client.BuildConfig
import com.bado.ignacio.reddit_client.data.TopService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @JvmStatic
    fun provideTopService(retrofit: Retrofit): TopService {
        return retrofit.create(TopService::class.java)
    }
}