package com.cross.share.com.splash

import androidx.lifecycle.ViewModel
import com.cross.share.com.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class CrossSplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(CrossSplashViewModel::class)
    @Singleton
    internal abstract fun postListViewModel(viewModel: CrossSplashViewModel): ViewModel
}