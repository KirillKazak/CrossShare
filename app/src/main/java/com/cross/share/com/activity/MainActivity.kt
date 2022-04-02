package com.cross.share.com.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cross.navigation.CrossFragmentNavigationCommand
import com.cross.navigation.CrossFragmentStates
import com.cross.navigation.NavigationActivity
import com.cross.share.com.R
import com.cross.share.com.base.GlobalNavigationImpl

class MainActivity : AppCompatActivity(), NavigationActivity {

    val navigator by lazy { GlobalNavigationImpl.apply { setActiveActivity(this@MainActivity) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.navigateToState(CrossFragmentStates.CROSS_SPLASH)
    }

    fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.applicationFrameContainer)
    }

    override fun navigateToState(
        state: CrossFragmentStates,
        data: Bundle?,
        tag: String?,
        navigationCommand: CrossFragmentNavigationCommand
    ) {
        navigator.navigateToState(state, data, tag, navigationCommand)
    }
}