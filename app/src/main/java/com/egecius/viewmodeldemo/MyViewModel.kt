package com.egecius.viewmodeldemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// saved state goes here into SavedStateHandle
class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var counter = MutableLiveData(0)

    init {
        Log.v("Eg:MyViewModel:11", "() savedStateHandle: $savedStateHandle")
    }

    fun onButtonClicked() {
        val updated = counter.value!! + 1
        counter.value = updated
    }
}