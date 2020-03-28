package com.egecius.viewmodeldemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // now you can use very simple function viewModels() to init ViewModel from anywhere
    private val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        updateOnDataChanges()
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
