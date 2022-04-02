package com.crossapp.core.base.vm

import androidx.lifecycle.ViewModel
import com.cross.navigation.CrossFragmentStates
import com.cross.navigation.CrossNavState
import com.crossapp.core.SingleLiveEvent

abstract class CrossBaseViewModel : ViewModel() {
    val navigation = SingleLiveEvent<CrossNavState>()
}