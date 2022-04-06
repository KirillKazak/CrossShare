package com.crossapp.core.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.cross.navigation.NavigationActivity
import com.crossapp.core.base.vm.CrossBaseViewModel

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class CrossBaseFragment<VM : CrossBaseViewModel, VB: ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    abstract val vm : VM

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initComponent()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

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

    abstract fun initComponent()

    abstract fun onBindViewModel(vm: VM) // implement base subscriptions here
}