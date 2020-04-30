package com.egecius.viewmodeldemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.egecius.viewmodeldemo.DetailActivityViewModel

class DetailActivityViewModelFactory(private val stringDependency: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DetailActivityViewModel(stringDependency) as T
    }
}