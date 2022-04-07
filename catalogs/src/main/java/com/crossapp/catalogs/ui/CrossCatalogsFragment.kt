package com.crossapp.catalogs.ui

import androidx.fragment.app.viewModels
import com.crossapp.catalogs.R
import com.crossapp.catalogs.di.DaggerCrossCatalogsComponent
import com.crossapp.catalogs.vm.CrossCatalogsViewModel
import com.crossapp.core.base.fragment.CrossBaseFragment
import com.crossapp.core.base.vm.ViewModelFactory
import com.crossapp.core.di.CoreInjectHelper
import javax.inject.Inject

class CrossCatalogsFragment : CrossBaseFragment<CrossCatalogsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val screenLayout= R.layout.cross_catalogs_fragment

    override val vm: CrossCatalogsViewModel by viewModels { viewModelFactory }

    override fun initComponent() {
        DaggerCrossCatalogsComponent.builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(requireActivity().applicationContext))
            .build().inject(this)
    }

    override fun onBindViewModel(vm: CrossCatalogsViewModel) {

    }

}