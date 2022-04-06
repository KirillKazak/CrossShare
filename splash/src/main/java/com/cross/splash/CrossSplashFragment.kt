package com.cross.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cross.splash.databinding.FragmentSpashBinding
import com.crossapp.core.base.fragment.CrossBaseFragment
import com.crossapp.core.base.vm.ViewModelFactory
import com.crossapp.core.di.CoreInjectHelper
import javax.inject.Inject

class CrossSplashFragment : CrossBaseFragment<CrossSplashViewModel, FragmentSpashBinding>(FragmentSpashBinding::inflate) {

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