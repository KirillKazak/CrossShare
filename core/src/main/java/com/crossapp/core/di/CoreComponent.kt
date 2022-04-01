package com.crossapp.core.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, NetworkModule::class])
interface CoreComponent {

    fun appContext(): Context

}