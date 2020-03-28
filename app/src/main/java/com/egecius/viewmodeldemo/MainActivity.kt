package com.egecius.viewmodeldemo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MyViewModel by viewModels()


        increment_button.setOnClickListener {
            model.onButtonClicked()
        }

        model.counter.observe(this, Observer {
            counter_text_view.text = it.toString()
        })
    }
}
