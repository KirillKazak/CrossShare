package com.crossapp.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://earthquake.usgs.gov/fdsnws/event/1/quety?format=geojson")
            .addConverterFactory(converterFactory).client(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}