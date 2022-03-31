package com.cross.share.com

import android.app.Application
import android.content.Context
import com.cross.share.com.di.AppComponent
import com.cross.share.com.di.DaggerAppComponent
import com.google.firebase.FirebaseApp


class CrossShareApplication : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
      get() = checkNotNull(_appComponent) {"AppComponent is not initialized"}

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.create()
        FirebaseApp.initializeApp(this)
    }
}