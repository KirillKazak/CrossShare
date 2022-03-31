package com.cross.share.com.splash

import androidx.fragment.app.viewModels
import com.cross.share.com.CrossShareApplication
import com.cross.share.com.R
import com.cross.share.com.base.CrossBaseFragment
import com.cross.share.com.base.ViewModelFactory
import javax.inject.Inject

class CrossSplashFragment : CrossBaseFragment<CrossSplashViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val screenLayout: Int = R.layout.fragment_spash

    override val vm: CrossSplashViewModel by viewModels { viewModelFactory }

    override fun onBindViewModel(vm: CrossSplashViewModel) {}

    override fun initComponent() {
        (requireActivity().application as CrossShareApplication).appComponent.inject(this)
    }
}