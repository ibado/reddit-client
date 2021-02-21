package com.bado.ignacio.reddit_client.data

import com.bado.ignacio.reddit_client.domain.EntryRepository
import javax.inject.Inject

class EntryRemoteDataSource @Inject constructor(private val service: TopService) : EntryRepository {

    override suspend fun getTop() = service.getTop().toEntryList()
}
