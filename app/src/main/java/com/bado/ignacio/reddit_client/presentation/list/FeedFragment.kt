package com.bado.ignacio.reddit_client.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bado.ignacio.reddit_client.R
import com.bado.ignacio.reddit_client.databinding.FragmentFeedBinding
import com.bado.ignacio.reddit_client.di.AppComponent
import com.bado.ignacio.reddit_client.presentation.MainViewModel
import com.bado.ignacio.reddit_client.presentation.Result
import java.lang.RuntimeException

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private lateinit var injector: AppComponent

    private val viewModel: MainViewModel by viewModels {
        injector.getMainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments ?: throw RuntimeException("Argument is missed")
        injector = args.getSerializable(INJECTOR_ARG) as AppComponent
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFeedBinding.bind(view)

        val adapter = FeedAdapter(emptyList())
        binding.feedList.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            setAdapter(adapter)
        }

        viewModel.entries.observe(viewLifecycleOwner) {
            binding.swipeLayout.apply { if (isRefreshing) isRefreshing = false }
            when (it) {
                is Result.Ok -> adapter.setEntries(it.value)
                is Result.Error ->
                    Log.e(TAG, "error fetching entries: ${it.throwable.message}")
            }
        }

        binding.swipeLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    companion object {
        val TAG = FeedFragment::class.simpleName
        private const val INJECTOR_ARG = "injector_arg"

        fun newInstance(injector: AppComponent) = FeedFragment().apply {
            arguments = bundleOf(
                INJECTOR_ARG to injector,
            )
        }
    }
}