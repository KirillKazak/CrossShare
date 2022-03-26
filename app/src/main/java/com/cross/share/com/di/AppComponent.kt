package com.cross.share.com.di

import com.cross.share.com.CrossShareApplication
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: CrossShareApplication)
    //fun appContext() : Context
}