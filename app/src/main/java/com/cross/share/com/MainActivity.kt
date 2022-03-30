package com.cross.share.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cross.share.com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBindingMainActivity: ActivityMainBinding
    val navigator by lazy { GlobalNavigation.apply { setActiveActivity(this@MainActivity) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBindingMainActivity.root)
        navigator.startFragment(CrossSplashFragment())
    }

    fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(viewBindingMainActivity.applicationFrameContainer.id)
    }

}