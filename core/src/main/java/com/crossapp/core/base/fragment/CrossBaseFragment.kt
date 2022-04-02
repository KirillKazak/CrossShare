package com.crossapp.core.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.cross.navigation.NavigationActivity
import com.crossapp.core.base.vm.CrossBaseViewModel

abstract class CrossBaseFragment<VM : CrossBaseViewModel> : Fragment() {

    @get:LayoutRes
    abstract val screenLayout: Int

    abstract val vm : VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(screenLayout, container, false)
    }

    abstract fun initComponent()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initComponent()
    }


   abstract fun onBindViewModel(vm: VM) // implement base subscriptions here

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.navigation.observe(this) {
            (requireActivity() as NavigationActivity).navigateToState(
                state = it.state,
                data = it.data,
                tag = it.tag,
                navigationCommand = it.navCom
            )
        }
        onBindViewModel(vm)

    }

}