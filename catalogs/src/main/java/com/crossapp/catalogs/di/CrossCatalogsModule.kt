package com.crossapp.catalogs.di

import androidx.lifecycle.ViewModel
import com.crossapp.catalogs.vm.CrossCatalogsViewModel
import com.crossapp.core.base.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class CrossCatalogsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CrossCatalogsViewModel::class)
    internal abstract fun bindCrossCatalogsViewModel(viewModel: CrossCatalogsViewModel): ViewModel

}