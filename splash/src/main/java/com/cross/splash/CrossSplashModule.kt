package com.cross.splash

import androidx.lifecycle.ViewModel
import com.crossapp.core.base.vm.ViewModelBuilderModule
import com.crossapp.core.base.vm.ViewModelKey
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