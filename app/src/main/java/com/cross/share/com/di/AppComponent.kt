package com.cross.share.com.di

import android.content.Context
import com.cross.share.com.CrossShareApplication
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: CrossShareApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}