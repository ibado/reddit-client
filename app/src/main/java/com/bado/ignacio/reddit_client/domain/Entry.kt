package com.bado.ignacio.reddit_client.domain

data class Entry(
    val title: String,
    val author: String,
    val created: Long,
    val thumbnailUrl: String,
    val commentCount: Int,
)
