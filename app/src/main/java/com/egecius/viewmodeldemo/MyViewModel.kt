package com.egecius.viewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
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