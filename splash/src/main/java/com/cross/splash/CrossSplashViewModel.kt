package com.cross.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CrossSplashViewModel @Inject constructor(): ViewModel() {
    fun show(){
        Log.d("CheckViewModel", "Show")
    }
}