package com.egecius.viewmodeldemo.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.egecius.viewmodeldemo.detail.di.DaggerDetailActivityComponent
import com.egecius.viewmodeldemo.detail.di.DetailActivityModule
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        Log.v("Eg:DetailActivity:16", "onCreate() viewModel: $viewModel")
    }

    private fun injectDependencies() {
        DaggerDetailActivityComponent.builder()
            .detailActivityModule(DetailActivityModule(this))
            .build().injectInto(this)
    }
}