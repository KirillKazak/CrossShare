package com.cross.share.com

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cross.share.com.activity.MainActivity
import com.cross.share.com.base.CrossBaseFragment
import com.cross.share.com.base.CrossFragmentNavigationCommand
import java.lang.ref.WeakReference

object GlobalNavigation {
    private var activity: WeakReference<AppCompatActivity>? = null

    fun setActiveActivity(activity: AppCompatActivity){
        this.activity = WeakReference<AppCompatActivity>(activity)
    }

    fun getVisibleActivity(): AppCompatActivity? = this.activity?.get()

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


    fun startFragment(
        fragment: CrossBaseFragment, data: Bundle? = null, tag: String? = null,
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
}
