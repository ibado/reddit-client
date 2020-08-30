package com.bado.ignacio.reddit_client.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.bado.ignacio.reddit_client.databinding.ActivityMainBinding
import com.bado.ignacio.reddit_client.presentation.list.FeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, FeedFragment())
        }
    }
}