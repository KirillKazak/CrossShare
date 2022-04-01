package com.cross.share.com.splash.ui

import androidx.fragment.app.viewModels
import com.cross.share.com.R
import com.cross.share.com.base.CrossBaseFragment
import com.cross.share.com.splash.di.DaggerCrossSplashComponent
import com.cross.share.com.splash.vm.CrossSplashViewModel
import com.crossapp.core.base.ViewModelFactory
import com.crossapp.core.di.CoreInjectHelper
import javax.inject.Inject

class CrossSplashFragment : CrossBaseFragment<CrossSplashViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val screenLayout: Int = R.layout.fragment_spash

    override val vm: CrossSplashViewModel by viewModels { viewModelFactory }

    override fun onBindViewModel(vm: CrossSplashViewModel) {
        vm.show()
    }

    override fun initComponent() {
        DaggerCrossSplashComponent.builder().coreComponent(CoreInjectHelper.provideCoreComponent(requireActivity().applicationContext)).build().inject(this)
    }
}