package com.bado.ignacio.reddit_client.domain

interface EntryRepository {

    suspend fun getTop(): List<Entry>
}