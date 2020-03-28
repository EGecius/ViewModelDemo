package com.egecius.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MyViewModel by viewModels()
        model.getUsers().observe(this, Observer { users ->
            Log.v("Eg:MainActivity:16", "onCreate() users: $users")
        })
    }
}
