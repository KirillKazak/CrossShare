package com.crossapp.catalogs.di

import com.crossapp.catalogs.api.CrossCatalogsServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CrossCatalogsApiModule {
    @Provides
   internal fun provideCatalogsApi(retrofit: Retrofit) = retrofit.create(CrossCatalogsServiceApi::class.java)
}