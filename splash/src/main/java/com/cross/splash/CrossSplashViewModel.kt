package com.cross.splash

import com.cross.navigation.CrossFragmentStates
import com.cross.navigation.CrossNavState
import com.crossapp.core.base.vm.CrossBaseViewModel
import com.crossapp.core.networkRequest
import javax.inject.Inject

class CrossSplashViewModel @Inject constructor(): CrossBaseViewModel() {
    fun show(){
        //TODO ADD ANIM AND DELAY
        navigation.value = CrossNavState(CrossFragmentStates.CROSS_CATALOGS)
    }
}