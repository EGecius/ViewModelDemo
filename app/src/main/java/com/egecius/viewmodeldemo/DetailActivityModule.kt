package com.egecius.viewmodeldemo

import androidx.activity.viewModels
import com.egecius.viewmodeldemo.detail.DetailActivity
import com.egecius.viewmodeldemo.di.DetailActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule(private val detailActivity: DetailActivity) {

    @Provides
    fun provideDetailActivityViewModel(factory: DetailActivityViewModelFactory): DetailActivityViewModel {

        val lazy: Lazy<DetailActivityViewModel> = detailActivity.viewModels {
            factory
        }

        val viewModel : DetailActivityViewModel by lazy
        return viewModel
    }

    @Provides
    fun provideDetailActivityViewModelFactory(): DetailActivityViewModelFactory {
        return DetailActivityViewModelFactory("string dependency")
    }
}