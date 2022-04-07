package com.crossapp.catalogs.di

import com.crossapp.catalogs.ui.CrossCatalogsFragment
import com.crossapp.core.di.CoreComponent
import com.crossapp.core.di.Screen
import dagger.Component


@Screen
@Component(dependencies = [CoreComponent::class], modules = [CrossCatalogsModule::class, CrossCatalogsApiModule::class])
interface CrossCatalogsComponent {
    fun inject(fragment : CrossCatalogsFragment)
}