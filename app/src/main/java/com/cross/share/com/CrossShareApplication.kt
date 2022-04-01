package com.cross.share.com

import android.app.Application
import com.cross.share.com.splash.di.CrossSplashComponent
import com.crossapp.core.di.*


class CrossShareApplication : Application(), CoreComponentProvider {


private lateinit var coreComponent: CoreComponent
private lateinit var splashComponent : CrossSplashComponent


    override fun onCreate() {
        super.onCreate()
        initCoreComponent()
        ///_appComponent = DaggerAppComponent.builder().context(this).build()
    }


    private fun initCoreComponent() {
        coreComponent = DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()

    }

   /* private fun initSplashComponent(){
        splashComponent = DaggerCrossSplashComponent.builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(this))
            .build()
    }*/

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            initCoreComponent()
        }
        return coreComponent
    }


}