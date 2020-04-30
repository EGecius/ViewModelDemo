package com.egecius.viewmodeldemo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.map
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.isActive

class MainActivity : AppCompatActivity() {

    // now you can use very simple function viewModels() to init ViewModel from anywhere

    private val model: MyViewModel by viewModels()

    // if you need to inject a factory into it:
//    val viewModel : PlayerActivityViewModel
//            by mainActivity.viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        updateOnDataChanges()
        initLifecycleScope()

        // even though a new ViewModel is created each time, its state is fully recreated
        Log.d("Eg:MainActivity:25", "onCreate() model.hashCode(): ${model.hashCode()}")
    }

    private fun initLifecycleScope() {
        lifecycleScope.launchWhenCreated {
            Log.v("Eg:MainActivity:26", "initLifecycleScope() launchWhenCreated")
        }
        lifecycleScope.launchWhenStarted {
            Log.v("Eg:MainActivity:30", "initLifecycleScope() launchWhenStarted")
        }
        lifecycleScope.launchWhenResumed {
            Log.v("Eg:MainActivity:33", "initLifecycleScope() launchWhenResumed")
        }
    }

    override fun onStop() {
        super.onStop()
        val isActive = lifecycleScope.isActive
        // scope will still be active onStop. It only gets cancelled in onDestroy()
        Log.v("Eg:MainActivity:41", "onStop() isActive: $isActive")
    }

    override fun onDestroy() {
        super.onDestroy()
        val isActive = lifecycleScope.isActive
        Log.v("Eg:MainActivity:48", "onDestroy() isActive: $isActive")
    }

    private fun updateOnDataChanges() {
        // you can also use extension function instead of us ing Transformations directly
        model.counter.map { it.toString() }
            .observe(this, Observer {
                counter_text_view.text = it
            })
    }

    private fun setListeners() {
        increment_button.setOnClickListener {
            model.onButtonClicked()
        }
    }
}
