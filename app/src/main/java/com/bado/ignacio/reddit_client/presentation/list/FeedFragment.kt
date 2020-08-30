package com.bado.ignacio.reddit_client.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bado.ignacio.reddit_client.R
import com.bado.ignacio.reddit_client.databinding.FragmentFeedBinding
import com.bado.ignacio.reddit_client.presentation.EntryView
import com.bado.ignacio.reddit_client.presentation.MainViewModel
import com.bado.ignacio.reddit_client.presentation.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFeedBinding.bind(view)

        val adapter = FeedAdapter(emptyList())
        binding.feedList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            setAdapter(adapter)
        }

        viewModel.entries.observe(viewLifecycleOwner) { result ->
            binding.swipeLayout.apply { if (isRefreshing) isRefreshing = false }
            when (result) {
                is Result.Ok -> adapter.setEntries(
                    result.value.map { EntryView.fromEntry(it) }
                )
                is Result.Error ->
                    Log.e(TAG, "error fetching entries: ${result.throwable.message}")
            }
        }

        binding.swipeLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    companion object {
        val TAG = FeedFragment::class.simpleName
    }
}