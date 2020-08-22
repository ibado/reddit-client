package com.bado.ignacio.reddit_client.domain

data class Entry(
    val title: String,
    val author: String,
    val thumbnailUrl: String,
    val commentCount: Int,
)