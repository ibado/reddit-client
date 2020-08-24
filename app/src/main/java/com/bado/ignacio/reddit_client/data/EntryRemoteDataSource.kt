package com.bado.ignacio.reddit_client.data

import com.bado.ignacio.reddit_client.domain.Entry
import com.bado.ignacio.reddit_client.domain.EntryRepository
import javax.inject.Inject

class EntryRemoteDataSource @Inject constructor(private val service: TopService) : EntryRepository {

    override suspend fun getTop() = service.getTop().toEntryList()

    private fun TopResponse.toEntryList(): List<Entry> {
        return this.data.children.map {
            val data = it.data
            Entry(
                data.title,
                data.author,
                data.created,
                data.thumbnailUrl,
                data.commentCount,
            )
        }.toList()
    }
}