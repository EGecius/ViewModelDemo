package com.egecius.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// saved state goes here into SavedStateHandle
class MainActivityViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var counter = MutableLiveData(getInitialCounter())

    private fun getInitialCounter(): Int {
        val savedValue = savedStateHandle.get<Int>(COUNTER)
        return savedValue ?: 0
    }

    fun onButtonClicked() {
        val updated = counter.value!! + 1
        counter.value = updated

        // save updatedValue here:
        savedStateHandle.set(COUNTER, updated)
    }

    companion object {

        const val COUNTER = "COUNTER"
    }
}