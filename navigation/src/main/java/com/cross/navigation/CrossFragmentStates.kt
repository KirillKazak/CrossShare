package com.cross.navigation

import android.os.Bundle

enum class CrossFragmentStates {
    CROSS_SPLASH,
    CROSS_CATALOGS
}

data class CrossNavState(val state: CrossFragmentStates, val data: Bundle? = null,val navCom: CrossFragmentNavigationCommand = CrossFragmentNavigationCommand.REPLACE, val tag: String? = null)

