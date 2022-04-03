package com.cross.share.com.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cross.navigation.CrossFragmentNavigationCommand
import com.cross.navigation.CrossFragmentStates

import com.cross.share.com.activity.MainActivity
import com.cross.share.com.R
import com.cross.splash.CrossSplashFragment
import com.crossapp.core.base.fragment.CrossBaseFragment
import java.lang.ref.WeakReference

object GlobalNavigationImpl {

    private var activity: WeakReference<AppCompatActivity>? = null

    fun setActiveActivity(activity: AppCompatActivity){
        this.activity = WeakReference<AppCompatActivity>(activity)
    }

    fun getVisibleActivity(): AppCompatActivity? = activity?.get()

    fun startActivity(clazz: Class<out AppCompatActivity>, data: Bundle?) {
        val activity = activity?.get() ?: throw  RuntimeException("No visible Activity was set")
        activity.startActivity(
            Intent(activity, clazz).apply {
                data?.let {
                    putExtras(it)
                }
            }
       )
    }


  private fun startFragment(
      fragment: CrossBaseFragment<*>, data: Bundle? = null, tag: String? = null,
      navigationCommand: CrossFragmentNavigationCommand = CrossFragmentNavigationCommand.ADD
    ) {
        val activity = activity?.get() ?: throw RuntimeException("No visible Activity was set")
        if (activity is MainActivity) {
            fragment.arguments = data
            if (navigationCommand == CrossFragmentNavigationCommand.REPLACE_AND_POP) {
                activity.supportFragmentManager.popBackStack()
            }

            val transition = activity.supportFragmentManager.beginTransaction()

            if (navigationCommand == CrossFragmentNavigationCommand.ADD) {
                transition.add(R.id.applicationFrameContainer, fragment, tag)
            } else {
                transition.replace(R.id.applicationFrameContainer, fragment, tag)
            }
            transition.addToBackStack(tag)
            transition.commit()
        }
  }

    fun navigateToState(
        state: CrossFragmentStates, data: Bundle? = null, tag: String? = null,
        navigationCommand: CrossFragmentNavigationCommand = CrossFragmentNavigationCommand.ADD
    ) {
        startFragment(fromStateToFragment(state), data, tag, navigationCommand)
    }


    private fun fromStateToFragment(state: CrossFragmentStates): CrossBaseFragment<*> {
        return when(state){
            CrossFragmentStates.CROSS_SPLASH -> CrossSplashFragment()
        }
    }
}