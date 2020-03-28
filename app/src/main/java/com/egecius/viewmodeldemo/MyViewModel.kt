package com.egecius.viewmodeldemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// saved state goes here into SavedStateHandle
class MyViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    
    init {
        Log.v("Eg:MyViewModel:11", "() savedStateHandle: $savedStateHandle")
    }

    private val users: MutableLiveData<List<User>> = MutableLiveData(getDefaultUsers())

    private fun getDefaultUsers(): List<User> {
        return listOf(User("egis"))
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}