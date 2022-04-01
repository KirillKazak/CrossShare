package com.cross.share.com.splash.di

import androidx.lifecycle.ViewModel
import com.cross.share.com.splash.vm.CrossSplashViewModel
import com.crossapp.core.base.ViewModelBuilderModule
import com.crossapp.core.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class CrossSplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(CrossSplashViewModel::class)
    internal abstract fun postListViewModel(viewModel: CrossSplashViewModel): ViewModel
}