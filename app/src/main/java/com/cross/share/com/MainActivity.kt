package com.cross.share.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cross.navigation.CrossFragmentStates

class MainActivity : AppCompatActivity() {

    val navigator by lazy { com.cross.share.com.base.GlobalNavigationImpl.apply { setActiveActivity(this@MainActivity) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.navigateToState(CrossFragmentStates.CROSS_SPLASH)
    }

    fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.applicationFrameContainer)
    }

}