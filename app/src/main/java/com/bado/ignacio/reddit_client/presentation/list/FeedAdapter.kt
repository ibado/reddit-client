package com.bado.ignacio.reddit_client.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bado.ignacio.reddit_client.databinding.FeedItemBinding
import com.bado.ignacio.reddit_client.domain.Entry
import com.bado.ignacio.reddit_client.presentation.loadFromURL

class FeedAdapter(
    private var entries: List<Entry>
) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(FeedItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(entries[position])
    }

    override fun getItemCount() = entries.size
    fun setEntries(entries: List<Entry>) {
        this.entries = entries
        notifyDataSetChanged()
    }

    class FeedViewHolder(
        private val binding: FeedItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Entry) {
            binding.tvAuthor.text = item.author
            binding.tvTitle.text = item.title
            binding.thumbnail.loadFromURL(item.thumbnailUrl)
        }
    }
}
