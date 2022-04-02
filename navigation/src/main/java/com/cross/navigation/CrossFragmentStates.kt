package com.cross.navigation

import android.os.Bundle

enum class CrossFragmentStates {
    CROSS_SPLASH
}

data class CrossNavState(val state: CrossFragmentStates, val data: Bundle? = null,val navCom: CrossFragmentNavigationCommand = CrossFragmentNavigationCommand.ADD, val tag: String? = null)

