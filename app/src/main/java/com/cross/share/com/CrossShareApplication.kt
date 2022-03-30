package com.cross.share.com

import android.app.Application
import com.cross.share.com.di.AppComponent
import com.cross.share.com.di.DaggerAppComponent


class CrossShareApplication : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
      get() = checkNotNull(_appComponent) {"AppComponent is not initialized"}

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder().context(this).build()
    }
}