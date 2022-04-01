package com.cross.share.com.splash.di

import com.cross.share.com.splash.ui.CrossSplashFragment
import com.crossapp.core.di.CoreComponent
import com.crossapp.core.di.Screen
import dagger.Component

@Screen
@Component(dependencies = [CoreComponent::class], modules = [CrossSplashModule::class])
interface CrossSplashComponent {
    fun inject(splashFragment: CrossSplashFragment)
}