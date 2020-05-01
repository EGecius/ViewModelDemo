package com.egecius.viewmodeldemo.detail.di

import com.egecius.viewmodeldemo.detail.DetailActivity
import dagger.Component

@Component(modules = [DetailActivityModule::class])
interface DetailActivityComponent {

    fun injectInto(detailActivity: DetailActivity)

}