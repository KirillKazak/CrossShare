package com.cross.navigation

import android.os.Bundle
import com.cross.navigation.CrossFragmentNavigationCommand
import com.cross.navigation.CrossFragmentStates

interface NavigationActivity {
    fun navigateToState(
        state: CrossFragmentStates, data: Bundle? = null, tag: String? = null,
        navigationCommand: CrossFragmentNavigationCommand
    )
}