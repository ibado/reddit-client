package com.bado.ignacio.reddit_client.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bado.ignacio.reddit_client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        injector.getMainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.entries.observe(this, Observer {
            when (it) {
                is Result.Ok -> Log.d("MainActivity", "success: ${it.value}")
                is Result.Error -> Log.d("MainActivity", "error: ${it.throwable.message}")
            }
        })
    }
}