package com.cross.share.com

import android.app.Application
import com.crossapp.core.di.*
import com.google.firebase.FirebaseApp


class CrossShareApplication : Application(), CoreComponentProvider {

private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        initCoreComponent()
    }


    private fun initCoreComponent() {
        coreComponent = DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()

    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            initCoreComponent()
        }
        return coreComponent
    }

}