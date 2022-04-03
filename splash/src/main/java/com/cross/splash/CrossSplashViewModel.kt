package com.cross.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import com.crossapp.core.base.vm.CrossBaseViewModel
import javax.inject.Inject

class CrossSplashViewModel @Inject constructor(): CrossBaseViewModel() {
    fun show(){
        Log.d("CheckViewModel", "Show")
    }
}