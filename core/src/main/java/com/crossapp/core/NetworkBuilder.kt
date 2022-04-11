package com.crossapp.core

import androidx.lifecycle.viewModelScope
import com.crossapp.core.base.vm.CrossBaseViewModel
import kotlinx.coroutines.CoroutineScope

class NetworkBuilder<T>{
    internal var loadingLambda: ((loaderVisibility: Boolean) -> Unit)? = null
    internal var startLambda: (() -> Unit)? = null
    internal var finishLambda: (() -> Unit)? = null
    internal var executionLambda: (suspend CoroutineScope.() -> T)? = null
    internal var success: ((result: T) -> Unit) = {}
    internal var error: (suspend CoroutineScope.(ErrorEntity) -> Unit)? = null
}

fun <T> NetworkBuilder<T>.onFinish(onFinish: () -> Unit) {
    this.finishLambda = onFinish
}

fun <T> NetworkBuilder<T>.onStart(onStart: () -> Unit) {
    this.startLambda = onStart
}

fun <T> NetworkBuilder<T>.loading(loading: (visibility: Boolean) -> Unit) {
    this.loadingLambda = loading
}

fun <T> NetworkBuilder<T>.execute(execution: suspend CoroutineScope.() -> T) {
    this.executionLambda = execution
}

fun <T> NetworkBuilder<T>.success(success: (T) -> Unit) {
    this.success = success
}

fun <T> NetworkBuilder<T>.error(error: suspend CoroutineScope.(ErrorEntity) -> Unit) {
    this.error = error
}

fun <T> CrossBaseViewModel.networkRequest(networkBuilder: NetworkBuilder<T>.() -> Unit){
    viewModelScope.networkOperation(networkBuilder)
}

data class ErrorEntity(val message: String, val statusCode: Int)