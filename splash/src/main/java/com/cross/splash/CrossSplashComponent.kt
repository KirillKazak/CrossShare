package com.cross.splash

import com.cross.splash.CrossSplashFragment
import com.crossapp.core.di.CoreComponent
import com.crossapp.core.di.Screen
import dagger.Component

@Screen
@Component(dependencies = [CoreComponent::class], modules = [CrossSplashModule::class])
interface CrossSplashComponent {
    fun inject(splashFragment: com.cross.splash.CrossSplashFragment)
}