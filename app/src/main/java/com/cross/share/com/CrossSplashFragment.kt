package com.cross.share.com

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.cross.share.com.base.CrossBaseFragment
import com.cross.share.com.databinding.FragmentSpashBinding

class CrossSplashFragment : CrossBaseFragment() {

    override fun setupViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        return FragmentSpashBinding.inflate(inflater)
    }

}