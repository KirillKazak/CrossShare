package com.cross.share.com.di

import android.content.Context
import com.cross.share.com.CrossShareApplication
import com.cross.share.com.base.ViewModelModule
import com.cross.share.com.splash.CrossSplashFragment
import com.cross.share.com.splash.CrossSplashModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class, CrossSplashModule::class])
interface AppComponent {

    fun inject(app: CrossSplashFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}