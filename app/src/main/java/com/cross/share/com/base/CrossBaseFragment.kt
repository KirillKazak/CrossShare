package com.cross.share.com.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.cross.share.com.R

abstract class CrossBaseFragment : Fragment() {

    @get:LayoutRes
    abstract val screenLayout: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(screenLayout, container, false)
    }

    private fun getCurrentFragment(): CrossBaseFragment? {
        val fragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainer) as? CrossBaseFragment
        return if (fragment?.isAdded == true) fragment else null
    }

    fun showFragment(
        fragment: CrossBaseFragment,
        tag: String?,
        navigationCommand: CrossFragmentNavigationCommand
    ) {
        if (navigationCommand == CrossFragmentNavigationCommand.REPLACE_AND_POP) {
            childFragmentManager.popBackStack()
        }

        val transition = childFragmentManager.beginTransaction()

        if (navigationCommand == CrossFragmentNavigationCommand.ADD) {
            transition.add(R.id.fragmentContainer, fragment, tag)
        } else {
            transition.replace(R.id.fragmentContainer, fragment, tag)
        }
        transition.addToBackStack(tag)
        transition.commit()
    }
}