package com.egecius.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// saved state goes here into SavedStateHandle
class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var counter = MutableLiveData(getInitialCounter())

    private fun getInitialCounter(): Int {
        return savedStateHandle.get<Int>(COUNTER) ?: 0
    }

    fun onButtonClicked() {
        val updated = counter.value!! + 1
        counter.value = updated
    }

    fun onDestroy() {
        savedStateHandle.set(COUNTER, counter.value)
    }

    companion object {

        const val COUNTER = "COUNTER"

    }
}