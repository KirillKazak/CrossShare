package com.cross.share.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cross.share.com.splash.CrossSplashFragment

class MainActivity : AppCompatActivity() {

    val navigator by lazy { GlobalNavigation.apply { setActiveActivity(this@MainActivity) } }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.startFragment(CrossSplashFragment())
    }

    fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.applicationFrameContainer)
    }

}