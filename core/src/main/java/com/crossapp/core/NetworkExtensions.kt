package com.crossapp.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun <T> CoroutineScope.networkOperation(networkBuilder: NetworkBuilder<T>.() -> Unit){
  this.launch {
      var errorEntity: ErrorEntity? = null
      with(NetworkBuilder<T>().apply { networkBuilder() }) {
          try {
              startLambda?.invoke()
              loadingLambda?.invoke(true)
              executionLambda?.invoke(this@networkOperation)!!
          } catch (e: Exception) {
              errorEntity = ErrorEntity(e.localizedMessage, 0)
          } finally {
              loadingLambda?.invoke(false)
              finishLambda?.invoke()
          }
      }
  }
}