package com.egecius.viewmodeldemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
        updateOnDataChanges()
    }

    private fun updateOnDataChanges() {
        model.counter.observe(this, Observer {
            counter_text_view.text = it.toString()
        })
    }

    private fun setListeners() {
        increment_button.setOnClickListener {
            model.onButtonClicked()
        }
    }
}
